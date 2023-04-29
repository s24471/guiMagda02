import java.util.ArrayList;

public class Cennik extends ArrayList<Price> {
    public static Cennik cennik;

    public Cennik() {
        super();
    }

    public static Cennik pobierzCennik() {
        if(cennik == null){
            cennik = new Cennik();
        }
        return cennik;
    }

    public void dodaj(String size, String type, int i, int i1, int i2) {
        cennik.add(new Price(size, type, i, i1, i2));
    }
    public void dodaj(String size, String type, int i, int i1) {
        cennik.add(new Price(size, type, i, i1));
    }
    public void dodaj(String size, String type, int i) {
        cennik.add(new Price(size, type, i));
    }

    public int getPrice(Paczka paczka){
        for(Price p: this){
            if(p.getType().equals(paczka.getType()))
                if(p.getSize().equals(paczka.getSize()))
                    return p.getPrice(paczka.getOdbior());
        }
        return -1;
    }
}
