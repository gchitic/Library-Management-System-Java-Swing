public class Cititor {
    private int id_cititor;
    private String nume;
    private String prenume;
    private String nr_tel;
    private String adresa;

    public Cititor(int id_cititor, String nume, String prenume, String nr_tel, String adresa) {
        this.id_cititor = id_cititor;
        this.nume = nume;
        this.prenume = prenume;
        this.nr_tel = nr_tel;
        this.adresa = adresa;
    }

    public Cititor(String nume, String prenume, String nr_tel, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.nr_tel = nr_tel;
        this.adresa = adresa;
    }

    public int getId_cititor() {
        return id_cititor;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setId_cititor(int id_cititor) {
        this.id_cititor = id_cititor;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Cititor{" +
                "id_cititor=" + id_cititor +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", nr_tel='" + nr_tel + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
