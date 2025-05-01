import java.sql.Date;

public abstract class Personne {
    private String nom;
    private int cin;
    private String prenom;
    private Date dateOfBirth;
    private int phone;
    private String gender;
    public Personne(int cin,String nom,String prenom,int phone){
        this.nom=nom;
        this.prenom=prenom;
        this.phone=phone;
        this.cin=cin;
    
    }
    public Personne(int cin,String nom,String prenom,Date dateOfBirth,int phone,String gender) throws Exception{
        this.nom=nom;
        this.prenom=prenom;
        this.phone=phone;
        this.cin=cin;
        this.dateOfBirth=dateOfBirth;
     //   this.verifDate();
        this.gender=gender;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getCin(){
        return this.cin;
    }
    
    public void setCin(int x)throws  Exception{
        if(this.verifphone(x)){
            this.cin=x;
        }
        else{
            throw new Exception("le cin doit avoir 8 chiffre");
        }
    }
    
    public boolean verifphone(int x){
        if(String.valueOf(x).length() == 8 && x>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getNom(){
        return nom;
    }   
    
    public void setNom(String n){
        nom=n;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public int getPhone() {
        return phone;
    }
    
    public void setPhone(int phone) throws Exception {
        if(this.verifphone(phone)){
            this.cin=phone;
        }
        else{
            throw new Exception("le cin doit avoir 8 chiffre");
        }
    }
    public String toString(){
        return  "nom : "+getNom()+"\n" +
                "prenom : "+getPrenom()+"\n"+
                "CIN : "+getCin()+"\n"+
                "date de naissance : "+getDateOfBirth().toString()+ "\n" +
                "tel : "+getPhone();
    }
    public String toShortString(){
        return
        "nom : "+getNom()+"\n" +
        "prenom : "+getPrenom()+"\n"+
        "CIN : "+getCin()+"\n"+
        "tel : "+getPhone();
    }
}
