
public class Price {
    private String size;
    private String type;
    private int wPunkcie;
    private int wAutomacie;
    private int dostawa;

    public Price(String size, String type, int dostawa) {
        this(size, type, dostawa, -1, -1);
    }
    public Price(String size, String type, int dostawa, int wPunkcie ) {
        this(size, type, dostawa, wPunkcie, -1);
    }

    public Price(String size, String type, int dostawa, int wPunkcie, int wAutomacie) {
        this.size = size.substring(0, 1).toUpperCase() + size.substring(1);
        this.type = type;
        this.wPunkcie = wPunkcie;
        this.wAutomacie = wAutomacie;
        this.dostawa = dostawa;
    }

    public int getPrice(Odbior odbior){
        return switch (odbior) {
            case PUNKT -> wPunkcie;
            case KURIER -> dostawa;
            case AUTOMAT -> wAutomacie;
        };
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
