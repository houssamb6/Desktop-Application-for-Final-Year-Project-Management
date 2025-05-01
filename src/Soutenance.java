import java.sql.Date;
import java.sql.Time;

public class Soutenance {
    private PFE pfe;
    private int id_soutenance; 
    private Jury jury;
    private Date dateSoutenance;
    private Time hDebut;
    private String place;
    private float note;
    public Soutenance(int id_soutenance,PFE pfe, Jury jury, Date dateSoutenance, Time hDebut, String place,float note) {
        this.pfe = pfe;
        this.id_soutenance = id_soutenance;
        this.jury = jury;
        this.dateSoutenance = dateSoutenance;
        this.hDebut = hDebut;
        this.place = place;
        this.note = note;
    }
    public PFE getPfe() {
        return pfe;
    }
    public void setPfe(PFE pfe) {
        this.pfe = pfe;
    }
    public int getId_soutenance() {
        return id_soutenance;
    }
    public void setId_soutenance(int id_soutenance) {
        this.id_soutenance = id_soutenance;
    }
    public Jury getJury() {
        return jury;
    }
    public void setJury(Jury jury) {
        this.jury = jury;
    }
    public Date getDateSoutenance() {
        return dateSoutenance;
    }
    public void setDateSoutenance(Date dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }
    public Time getHDebut() {
        return hDebut;
    }
    public void sethDebut(Time hDebut) {
        this.hDebut = hDebut;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public float getNote() {
        return note;
    }
    public void setNote(float note) {
        this.note = note;
    }
    public String toString(){
        return  "ID soutenance : "+this.getId_soutenance()+"\n" +
                "Date de la soutenance : "+this.getDateSoutenance().toString()+"\n"+
                "Heure de debut : "+this.getHDebut().toString()+"\n"+
                "Lieu : "+this.getPlace();
    }
    
    
    
}
