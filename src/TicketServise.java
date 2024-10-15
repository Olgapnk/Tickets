public class TicketServise {


    public Ticket create(String from, String to, int price){
        return new Ticket(from, to, price);
    }

    public void book(Ticket ticket){
        ticket.isBooked=true;
    }

    public void buy(Ticket ticket) throws TicketException {
        if (ticket.isBooked){
            throw new TicketException("Tickes is already booked");
        }
        ticket.isBought = true;
    }

    public void delete(Ticket ticket) throws TicketException {
        if (ticket.isBooked){
            throw new TicketException("Tickes is booked");
        }
        ticket.isAvailable = false;
    }
}
