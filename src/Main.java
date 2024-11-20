import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graphe graphe = new Graphe();

        Noeud lille = new Noeud("Lille", new ArrayList<Arets>());
        Noeud paris = new Noeud("Paris", new ArrayList<Arets>());
        Noeud reims = new Noeud("Reims", new ArrayList<Arets>());
        Noeud lyon = new Noeud("Lyon", new ArrayList<Arets>());
        Noeud marseille = new Noeud("Marseille", new ArrayList<Arets>());

        Arets arets1 = new Arets(225, lille, paris);
        Arets arets2 = new Arets(205, lille, reims);
        Arets arets3 = new Arets(144, reims, paris);
        Arets arets4 = new Arets(470, paris, lyon);
        Arets arets5 = new Arets(550, lyon, reims);
        Arets arets6 = new Arets(315, lyon, marseille);
        Arets arets7 = new Arets(600, marseille, paris);

        lille.getAretes().add(arets1);
        lille.getAretes().add(arets2);
        reims.getAretes().add(arets2);
        reims.getAretes().add(arets3);
        paris.getAretes().add(arets1);
        paris.getAretes().add(arets3);
        paris.getAretes().add(arets4);
        lyon.getAretes().add(arets4);
        lyon.getAretes().add(arets5);
        lyon.getAretes().add(arets6);
        marseille.getAretes().add(arets6);
        marseille.getAretes().add(arets7);
        paris.getAretes().add(arets7);

        graphe.ajouterNoeud(lille);
        graphe.ajouterNoeud(paris);
        graphe.ajouterNoeud(reims);
        graphe.ajouterNoeud(lyon);
        graphe.ajouterNoeud(marseille);

        Noeud noeudInitial = lille;
        Noeud destination = marseille;

        graphe.calculerDistances(noeudInitial);

        int[] distances = graphe.getDistances();
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from " + noeudInitial.getNom() + " to " + graphe.getNoeuds().get(i).getNom() + ": " + distances[i]);
        }

        ArrayList<Noeud> path = graphe.getShortestPath(destination);
        System.out.println("Shortest path from " + noeudInitial.getNom() + " to " + destination.getNom() + ": " + path);
    }
}