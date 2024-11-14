import java.util.ArrayList;
import java.util.Arrays;

public class Graphe {
    private ArrayList<Noeud> noeuds;
    private int[] distances;
    private boolean[] visites;

    public Graphe() {
        this.noeuds = new ArrayList<>();
    }

    public void ajouterNoeud(Noeud noeud) {
        noeuds.add(noeud);
    }

    public void initialiserDistances(Noeud noeudInitial) {
        distances = new int[noeuds.size()];
        visites = new boolean[noeuds.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visites, false);
        distances[noeuds.indexOf(noeudInitial)] = 0;
    }

    public void calculerDistances(Noeud noeudInitial) {
        initialiserDistances(noeudInitial);

        while (true) {
            int noeudCourantIndex = -1;
            int distanceMin = Integer.MAX_VALUE;

            for (int i = 0; i < noeuds.size(); i++) {
                if (!visites[i] && distances[i] < distanceMin) {
                    distanceMin = distances[i];
                    noeudCourantIndex = i;
                }
            }

            if (noeudCourantIndex == -1) {
                break;
            }

            visites[noeudCourantIndex] = true;
            Noeud noeudCourant = noeuds.get(noeudCourantIndex);

            for (Arets aret : noeudCourant.getAretes()) {
                Noeud voisin = aret.getNoeud1().equals(noeudCourant) ? aret.getNoeud2() : aret.getNoeud1();
                int voisinIndex = noeuds.indexOf(voisin);
                if (!visites[voisinIndex]) {
                    int nouvelleDistance = distances[noeudCourantIndex] + aret.getValeur();
                    if (nouvelleDistance < distances[voisinIndex]) {
                        distances[voisinIndex] = nouvelleDistance;
                    }
                }
            }
        }
    }

    public int shortestPath(Noeud noeudInitial, Noeud noeudFinal) {
        calculerDistances(noeudInitial);
        return distances[noeuds.indexOf(noeudFinal)];
    }

    public int[] getDistances() {
        return distances;
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }
}