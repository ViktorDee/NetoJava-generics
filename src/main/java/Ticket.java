public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int flightMinutes;

    public Ticket(int id, int price, String from, String to, int flightMinutes) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.flightMinutes = flightMinutes;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public int compareTo(Ticket o) {
        if (price < o.price) {
            return -1;
        }
        if (price > o.price) {
            return 1;
        }
            return 0;
    }
}
