import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Klient {
    private String name;
    private double budget;
    private ListaZamowien listaZamowien;
    private  boolean abonament;
    private Koszyk koszyk;

    public Klient(String name, int budget, boolean abonament) {
        this.name = name;
        this.budget = budget;
        this.abonament = abonament;
        listaZamowien = new ListaZamowien(this);
    }

    public void dodaj(Paczka n){
        listaZamowien.dodaj(n);
    }

    public ListaZamowien pobierzListeZyczen(){
        return listaZamowien;
    }
    public Koszyk pobierzKoszyk(){
        return koszyk;
    }

    public boolean isAbonament() {
        return abonament;
    }

    public String getName() {
        return name;
    }

    public double pobierzPortfel() {
        return budget;
    }

    public ListaZamowien pobierzListeZamowien() {
        return listaZamowien;
    }

    public void przepakuj(Koszyk koszyk){
        this.koszyk = koszyk;
        Cennik cennik = Cennik.pobierzCennik();
        ArrayList<Paczka> lista = pobierzListeZyczen().getList();
        List<Paczka> tmp = new ArrayList<>();
        for (Paczka n: lista) {
            if (cennik.getPrice(n) != -1) {
                koszyk.dodaj(n);
                tmp.add(n);
            }
        }
        for (Paczka n: tmp) {
            listaZamowien.usun(n);
        }
        // TODO: iterator
    }

    public void zaplac(String czym){
        double suma=0;
        double tmp = 1;
        if(czym.equals("karta")){
            tmp += 0.01;
        }
        if(abonament){
            tmp/=2;
        }
        ArrayList<Paczka> lista = koszyk.getList();
        lista.sort(new Comparator<Paczka>() {
            @Override
            public int compare(Paczka o1, Paczka o2) {
                return Double.compare(o1.getCena(), o2.getCena());
            }
        });
        while(lista.size()>0 && suma + lista.get(0).getCena() * tmp<= budget) {
            suma += lista.get(0).getCena() * tmp;
            lista.get(0).setIle(lista.get(0).getIle() - 1);
            if (lista.get(0).getIle() == 0) {
                lista.remove(0);
            }
        }

        budget-=suma;
        budget = round(budget);

    }
    public static double round(double d){
        BigDecimal bd = BigDecimal.valueOf(d);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
