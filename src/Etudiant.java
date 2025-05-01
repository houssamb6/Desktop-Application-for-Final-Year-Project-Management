import java.sql.Date;
public class Etudiant extends Personne {
    private String etude;
    private String  filière;
    private static int countEtu=0;
    public  Etudiant(Integer cin,String nom, String prenom,Date dateOfBirth,String gender,int phone,String etude,String filiére)throws Exception{
        super(cin,nom,prenom,dateOfBirth,phone,gender);
        this.etude=etude;
        this.filière=filiére;
        countEtu++;
    }
    public static int getCount(){
        return countEtu;
    } 
    public String getEtude() {
        return etude;
    }
    public void setEtude(String etude) {
        this.etude = etude;
    }
    public String getFilière() {
        return filière;
    }
    public void setFilière(String filière) {
        this.filière = filière;
    }
    public String toString(){
        return super.toString()+ "\n Etudie : "+getEtude()+"\n Filier :"+getFilière();
    }
}
