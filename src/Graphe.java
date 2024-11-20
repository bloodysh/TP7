import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graphe {
    private ArrayList<Noeud> noeuds;
    private int[] distances;
    private boolean[] visites;
    private Noeud[] predecessors;

    public Graphe() {
        this.noeuds = new ArrayList<>();
    }

    public void ajouterNoeud(Noeud noeud) {
        noeuds.add(noeud);
    }

    public void initialiserDistances(Noeud noeudInitial) {
        distances = new int[noeuds.size()];
        visites = new boolean[noeuds.size()];
        predecessors = new Noeud[noeuds.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visites, false);
        distances[noeuds.indexOf(noeudInitial)] = 0;
    }

    public void calculerDistances(Noeud noeudInitial) {
        initialiserDistances(noeudInitial);
        PriorityQueue<NoeudDistance> queue = new PriorityQueue<>();
        queue.add(new NoeudDistance(noeudInitial, 0));

        while (!queue.isEmpty()) {
            NoeudDistance noeudDistance = queue.poll();
            Noeud noeudCourant = noeudDistance.noeud;
            int noeudCourantIndex = noeuds.indexOf(noeudCourant);

            if (visites[noeudCourantIndex]) continue;
            visites[noeudCourantIndex] = true;

            for (Arets aret : noeudCourant.getAretes()) {
                Noeud voisin = aret.getNoeud1().equals(noeudCourant) ? aret.getNoeud2() : aret.getNoeud1();
                int voisinIndex = noeuds.indexOf(voisin);
                if (!visites[voisinIndex]) {
                    int nouvelleDistance = distances[noeudCourantIndex] + aret.getValeur();
                    if (nouvelleDistance < distances[voisinIndex]) {
                        distances[voisinIndex] = nouvelleDistance;
                        predecessors[voisinIndex] = noeudCourant;
                        queue.add(new NoeudDistance(voisin, nouvelleDistance));
                    }
                }
            }
        }
    }

    public ArrayList<Noeud> getShortestPath(Noeud destination) {
        ArrayList<Noeud> path = new ArrayList<>();
        for (Noeud at = destination; at != null; at = predecessors[noeuds.indexOf(at)]) {
            path.add(0, at);
        }
        return path;
    }

    public int[] getDistances() {
        return distances;
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    private static class NoeudDistance implements Comparable<NoeudDistance> {
        Noeud noeud;
        int distance;

        NoeudDistance(Noeud noeud, int distance) {
            this.noeud = noeud;
            this.distance = distance;
        }

        @Override
        public int compareTo(NoeudDistance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}