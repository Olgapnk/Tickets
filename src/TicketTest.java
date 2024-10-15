import org.junit.jupiter.api.*;

public class TicketTest {

    static TicketServise ticketServise = new TicketServise();
    static Ticket ticket = ticketServise.create("Moscow", "London", 100);
    int col =10;

    @BeforeAll
    public static void before(){
        System.out.println("Start testing");
    }

    @AfterEach
    public void setStatuses(){
        ticket.isBooked=false;
        ticket.isBought=false;
        ticket.isAvailable=true;
    }

    @Test
    public void testBook(){
        ticketServise.book(ticket);
        Assertions.assertEquals(true, ticket.isBooked);
        System.out.println("Ticket is booked");
    }

    @Test
    public void testBuy() throws TicketException {
//        Assertions.assertThrows(TicketException.class, ()->ticketServise.buy(ticket));
        ticketServise.buy(ticket);
        Assertions.assertEquals(true, ticket.isBought);
        System.out.println("Ticket is bought");
    }

    @Test
    public void testDelete() throws TicketException {
        ticketServise.delete(ticket);
        Assertions.assertEquals(false, ticket.isAvailable);
        System.out.println("Ticket is deleted");
    }

    @Test
    public void testException() throws TicketException {
        System.out.println("----exception test-----");
        ticketServise.book(ticket);
        Assertions.assertThrows(TicketException.class, ()->ticketServise.buy(ticket));
        Assertions.assertThrows(TicketException.class, ()->ticketServise.delete(ticket));
        System.out.println("Ticket can't be bought and deleted");
        System.out.println("------------------");
    }

    @AfterAll
    public static void after(){
        System.out.println("End testing");
    }

}
