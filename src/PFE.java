public class PFE {
    private int idGroupe;
    private Etudiant etudiant1;
    private Etudiant etudiant2;
    private Enseignant encadreur;
    private String projet;
    private int nbGroupe=0;
    public PFE(int idGroupe,Etudiant etudiant1,Etudiant etudiant2,Enseignant encadreur,String projet){
        this.idGroupe=idGroupe;
        this.etudiant1=etudiant1;
        this.etudiant2=etudiant2;
        this.encadreur=encadreur;
        this.projet=projet;
        nbGroupe++; //
    }
    public int getIdGroupe() {
        return idGroupe;
    }
    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }
    public Etudiant getEtudiant1() {
        return etudiant1;
    }
    public void setEtudiant1(Etudiant etudiant1) {
        this.etudiant1 = etudiant1;
    }
    public Etudiant getEtudiant2() {
        return etudiant2;
    }
    public void setEtudiant2(Etudiant etudiant2) {
        this.etudiant2 = etudiant2;
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
    public int getNbGroupe() {
        return nbGroupe;
    }
    public void setNbGroupe(int nbGroupe) {
        this.nbGroupe = nbGroupe;
    }
    public String toString(){
        return "PFE: "+this.getIdGroupe()+"\nRéalisé par :"+this.getEtudiant1()+"&&"+this.getEtudiant2()+", Projet: "+this.getProjet()+". Encadreur: "+this.getEncadreur().getNom()+" "+this.getEncadreur().getPrenom();
    }
}
