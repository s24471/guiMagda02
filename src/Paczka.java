public class Paczka {

    private String type;
    private String size;
    private int ile;
    private double cena;
    private Odbior odbior;

    public Paczka(String type, String size, int ile, Odbior odbior) {
        this.type = type;
        this.size = size.substring(0, 1).toUpperCase() + size.substring(1);
        this.ile = ile;
        this.odbior = odbior;
        cena = Cennik.cennik.getPrice(this);
    }

    public String getType() {
        return type;
    }
    public double getCena() {
        return cena;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setIle(int ile) {
        this.ile = ile;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setOdbior(Odbior odbior) {
        this.odbior = odbior;
    }

    public String getSize() {
        return size;
    }

    public int getIle() {
        return ile;
    }

    public Odbior getOdbior() {
        return odbior;
    }
}
