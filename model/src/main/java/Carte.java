public class Carte {
    private int id_carte;
    private String denumire;
    private String autor;
    private String editura;
    private String domeniul;
    private int an_aparitie;

    public Carte(int id_carte, String denumire, String autor, String editura, String domeniul, int an_aparitie) {
        this.id_carte = id_carte;
        this.denumire = denumire;
        this.autor = autor;
        this.editura = editura;
        this.domeniul = domeniul;
        this.an_aparitie = an_aparitie;
    }

    public Carte(String denumire, String autor, String editura, String domeniul, int an_aparitie) {
        this.denumire = denumire;
        this.autor = autor;
        this.editura = editura;
        this.domeniul = domeniul;
        this.an_aparitie = an_aparitie;
    }

    public int getId_carte() {
        return id_carte;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditura() {
        return editura;
    }

    public String getDomeniul() {
        return domeniul;
    }

    public int getAn_aparitie() {
        return an_aparitie;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public void setDomeniul(String domeniul) {
        this.domeniul = domeniul;
    }

    public void setAn_aparitie(int an_aparitie) {
        this.an_aparitie = an_aparitie;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id_carte=" + id_carte +
                ", denumire='" + denumire + '\'' +
                ", autor='" + autor + '\'' +
                ", editura='" + editura + '\'' +
                ", domeniul='" + domeniul + '\'' +
                ", an_aparitie=" + an_aparitie +
                '}';
    }
}
