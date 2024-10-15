public class Ticket {

    String from;
    String to;
    int price;
    Boolean isBooked = false;
    Boolean isBought = false;
    Boolean isAvailable = true;

    public Ticket(String from, String to, int price){
        this.from = from;
        this.to = to;
        this.price = price;
    }

}
