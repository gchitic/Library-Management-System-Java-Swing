import java.util.Date;

public class Returnare {
    private int id_returnare;
    private int inchiriere_id;
    private Date data_return;

    private int carte_id;
    private String carte;
    private int cititor_id;
    private String cititor;
    private String nr_tel;
    private String adresa;
    private Date data_inchiriere;
    private Date data_estim_return;

    public Returnare(int id_returnare, int inchiriere_id, Date data_return) {
        this.id_returnare = id_returnare;
        this.inchiriere_id = inchiriere_id;
        this.data_return = data_return;
    }

    public Returnare(int inchiriere_id, Date data_return) {
        this.inchiriere_id = inchiriere_id;
        this.data_return = data_return;
    }

    public Returnare(int id_returnare, int inchiriere_id, Date data_return, int carte_id, String carte, int cititor_id,
                     String cititor, String nr_tel, String adresa, Date data_inchiriere, Date data_estim_return) {
        this.id_returnare = id_returnare;
        this.inchiriere_id = inchiriere_id;
        this.data_return = data_return;
        this.carte_id = carte_id;
        this.carte = carte;
        this.cititor_id = cititor_id;
        this.cititor = cititor;
        this.nr_tel = nr_tel;
        this.adresa = adresa;
        this.data_inchiriere = data_inchiriere;
        this.data_estim_return = data_estim_return;
    }

    public int getId_returnare() {
        return id_returnare;
    }

    public int getInchiriere_id() {
        return inchiriere_id;
    }

    public Date getData_return() {
        return data_return;
    }

    public void setId_returnare(int id_returnare) {
        this.id_returnare = id_returnare;
    }

    public void setInchiriere_id(int inchiriere_id) {
        this.inchiriere_id = inchiriere_id;
    }

    public void setData_return(Date data_return) {
        this.data_return = data_return;
    }

    public int getCarte_id() {
        return carte_id;
    }

    public String getCarte() {
        return carte;
    }

    public int getCititor_id() {
        return cititor_id;
    }

    public String getCititor() {
        return cititor;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public String getAdresa() {
        return adresa;
    }

    public Date getData_inchiriere() {
        return data_inchiriere;
    }

    public Date getData_estim_return() {
        return data_estim_return;
    }

    public void setCarte_id(int carte_id) {
        this.carte_id = carte_id;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public void setCititor_id(int cititor_id) {
        this.cititor_id = cititor_id;
    }

    public void setCititor(String cititor) {
        this.cititor = cititor;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setData_inchiriere(Date data_inchiriere) {
        this.data_inchiriere = data_inchiriere;
    }

    public void setData_estim_return(Date data_estim_return) {
        this.data_estim_return = data_estim_return;
    }
}
