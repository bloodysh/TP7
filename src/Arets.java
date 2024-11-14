import java.util.ArrayList;

public class Arets {
    private int valeur;
    private Noeud noeud1;
    private Noeud noeud2;

    public Arets(int valeur, Noeud noeud1, Noeud noeud2) {
        this.valeur = valeur;
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Noeud getNoeud1() {
        return noeud1;
    }

    public void setNoeud1(Noeud noeud1) {
        this.noeud1 = noeud1;
    }

    public Noeud getNoeud2() {
        return noeud2;
    }

    public void setNoeud2(Noeud noeud2) {
        this.noeud2 = noeud2;
    }

    @Override
    public String toString() {
        return "" + noeud1 + " à " + noeud2 + " : " + this.getValeur();
    }
}
