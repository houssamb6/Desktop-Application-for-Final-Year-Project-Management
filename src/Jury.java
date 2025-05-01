import javafx.scene.control.Button;

public class Jury{
    private int idJury;
    private Enseignant president;
    private Enseignant rapporteur;
    private Enseignant examinateur;
    private Encadreur invite;
    private Button buttonAffiche;
    private static int nbJury=0;
    public  Jury(int idJury,Enseignant president, Enseignant rapporteur,Enseignant examinateur,Encadreur invite){
        this.idJury=idJury;
        this.president = president;
        this.rapporteur = rapporteur;
        this.examinateur = examinateur;
        this.invite = invite;
        nbJury++;
    }
    public int getIdJury() {
        return idJury;
    }
    public void setIdJury(int idJury) {
        this.idJury = idJury;
    }
    public Enseignant getPresident() {
        return president;
    }
    public void setPresident(Enseignant president) {
        this.president = president;
    }
    public Enseignant getRapporteur() {
        return rapporteur;
    }
    public void setRapporteur(Enseignant rapporteur) {
        this.rapporteur = rapporteur;
    }
    public Enseignant getExaminateur() {
        return examinateur;
    }
    public void setExaminateur(Enseignant examinateur) {
        this.examinateur = examinateur;
    }
    public Encadreur getInvite() {
        return invite;
    }
    public void setInvite(Encadreur invite) {
        this.invite = invite;
    }
    public Button getButtonAffiche() {
        return buttonAffiche;
    }
    public void setButtonAffiche(Button buttonAffiche) {
        this.buttonAffiche = buttonAffiche;
    }
    public static int getNbJury() {
        return nbJury;
    }
    public static void setNbJury(int nbJury) {
        Jury.nbJury = nbJury;
    }
    public String toString() {
        return (
            "Jury ID: " + idJury + "\n" +
            "President: " + president + "\n" +
            "Rapporteur: " + rapporteur + "\n" +
            "Examinateur: " + examinateur + "\n" +
            "Encadreur Invité: " + invite
        );
    }
}
