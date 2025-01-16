import java.util.Date;

public class Inchiriere {
    private int id_inchiriere;
    private int carte_id;
    private int cititor_id;
    private Date data_inchiriere;
    private Date data_estim_return;

    private String carte;
    private String cititor;
    private String nr_tel;
    private String adresa;

    public Inchiriere(int id_inchiriere, int carte_id, int cititor_id, Date data_inchiriere, Date data_estim_return, String carte, String cititor, String nr_tel, String adresa) {
        this.id_inchiriere = id_inchiriere;
        this.carte_id = carte_id;
        this.cititor_id = cititor_id;
        this.data_inchiriere = data_inchiriere;
        this.data_estim_return = data_estim_return;
        this.carte = carte;
        this.cititor = cititor;
        this.nr_tel = nr_tel;
        this.adresa = adresa;
    }

    public Inchiriere(int carte_id, int cititor_id, Date data_inchiriere, Date data_estim_return) {
        this.carte_id = carte_id;
        this.cititor_id = cititor_id;
        this.data_inchiriere = data_inchiriere;
        this.data_estim_return = data_estim_return;
    }

    public int getId_inchiriere() {
        return id_inchiriere;
    }

    public int getCarte_id() {
        return carte_id;
    }

    public int getCititor_id() {
        return cititor_id;
    }

    public Date getData_inchiriere() {
        return data_inchiriere;
    }

    public Date getData_estim_return() {
        return data_estim_return;
    }

    public void setId_inchiriere(int id_inchiriere) {
        this.id_inchiriere = id_inchiriere;
    }

    public void setCarte_id(int carte_id) {
        this.carte_id = carte_id;
    }

    public void setCititor_id(int cititor_id) {
        this.cititor_id = cititor_id;
    }

    public void setData_inchiriere(Date data_inchiriere) {
        this.data_inchiriere = data_inchiriere;
    }

    public void setData_estim_return(Date data_estim_return) {
        this.data_estim_return = data_estim_return;
    }

    @Override
    public String toString() {
        return "Inchiriere{" +
                "id_inchiriere=" + id_inchiriere +
                ", carte_id=" + carte_id +
                ", cititor_id=" + cititor_id +
                ", data_inchiriere=" + data_inchiriere +
                ", data_estim_return=" + data_estim_return +
                '}';
    }

    public String getCarte() {
        return carte;
    }

    public String getCititor() {
        return cititor;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public void setCititor(String cititor) {
        this.cititor = cititor;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
