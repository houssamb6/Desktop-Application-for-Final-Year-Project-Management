

public class Encadreur extends Personne {
    private String societe;
    public  Encadreur(int cin, String nom, String prenom,int phone,String societe) throws Exception {
        super(cin,nom,prenom,phone);
        this.societe=societe;
    }
    public String getSociete() {
        return societe;
    }
    public void setSociete(String societe) {
        this.societe = societe;
    }
    public String  toString(){
        return super.toShortString()+"\n Société : "+this.getSociete();
    }
}
