import java.util.ArrayList;

public class Noeud {
    private String nom;
    private ArrayList<Arets> aretes;

    public Noeud(String nom, ArrayList<Arets> aretes) {
        this.nom = nom;
        this.aretes = aretes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Arets> getAretes() {
        return aretes;
    }

    public void setAretes(ArrayList<Arets> aretes) {
        this.aretes = aretes;
    }
    @Override
    public String toString() {
        return nom;
    }
}
