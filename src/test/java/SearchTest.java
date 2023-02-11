import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1200, "VKO", "KZN", 55);
    Ticket ticket2 = new Ticket(3, 1100, "MOV", "OVB", 95);
    Ticket ticket3 = new Ticket(5,5000, "OGZ", "KUF", 112);
    Ticket ticket4 = new Ticket(2,4000, "KUF", "VKO", 205);
    Ticket ticket5 = new Ticket(12, 3500, "GOJ", "MOV", 107);
    Ticket ticket6 = new Ticket(56, 750, "VKO", "OVB", 91);
    Ticket ticket7 = new Ticket(23, 1250, "VKO", "KZN", 95);
    Ticket ticket8 = new Ticket(34, 1150, "VKO", "KZN", 95);
    Ticket ticket9 = new Ticket(11, 1050, "VKO", "KZN", 95);
    Ticket ticket10 = new Ticket(61, 1000, "VKO", "KZN", 95);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }
    @Test
    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.findAll("OGZ", "KUF");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByCost() {

        Ticket[] expected = {ticket10, ticket9, ticket8, ticket1, ticket7};
        Ticket[] actual = manager.findAll("VKO","KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VKO", "MOV");

        Assertions.assertArrayEquals(expected, actual);
    }
}
