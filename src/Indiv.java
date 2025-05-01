public class Indiv {
    private Etudiant etudiant;
    private Enseignant encadreur;
    private String projet;
    private static int nbIndiv=0;
    public Indiv(Etudiant etudiant,Enseignant encadreur,String projet){
        this.etudiant = etudiant ;
        this.encadreur = encadreur;
        this.projet = projet;
        nbIndiv++;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public Enseignant getEncadreur() {
        return encadreur;
    }
    public void setEncadreur(Enseignant encadreur) {
        this.encadreur = encadreur;
    }
    public String getProjet() {
        return projet;
    }
    public void setProjet(String projet) {
        this.projet = projet;
    }
    public static int getNbIndiv() {
        return nbIndiv;
    }
    public static void setNbIndiv(int nbIndiv) {
        Indiv.nbIndiv = nbIndiv;
    }
}
