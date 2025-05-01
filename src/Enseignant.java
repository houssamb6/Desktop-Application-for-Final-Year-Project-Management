
public class Enseignant extends Personne {

    private static int countEnseignant = 0;
    private  String specialite;

    public Enseignant(int cin, String nom, String prenom,int phone,String specialite) throws Exception {
        super(cin, nom, prenom, phone);
        countEnseignant++;
        this.specialite=specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getCountEnsei() {
        return countEnseignant;
    }
    public String toString(){
        return super.toShortString() + "Spécialité : "+this.getSpecialite();
    }
    public static void main(String[] args) throws Exception {
        
     }
}


