import java.util.ArrayList;

public abstract class Lista {
    private ArrayList<Paczka> list;
    private Klient k;
    public Lista(Klient k) {
        this.k=k;
        this.list = new ArrayList<Paczka>();
    }

    public Klient getK() {
        return k;
    }

    public void dodaj(Paczka n){
        list.add(n);
    }

    public ArrayList<Paczka> getList() {
        return list;
    }

    public void usun(Paczka n){
        list.remove(n);
    }

    @Override
    public String toString() {
        if(list.size()==0)return k.getName() + ": -- pusto";
        String w=k.getName() + ":\n";
        for (Paczka n: list) {
            String o = switch (n.getOdbior()){
                case PUNKT -> "w punkcie";
                case KURIER -> "kurier";
                case AUTOMAT -> "automat";
            };
            w+=n.getSize() + ", typ: " + n.getType() + ", ile: " + n.getIle()+", odbiór: " + o +", cena " + (n.getCena()==-1?"0.00":(k.isAbonament()?n.getCena()/2:n.getCena())) + "\n";
        }
        return w;
    }
}
