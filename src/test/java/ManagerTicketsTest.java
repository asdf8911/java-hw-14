import static org.junit.jupiter.api.Assertions.*; // для короких ассертов

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTicketsTest {
    protected Ticket[] tickets = new Ticket[6];
    RepositoryTickets repo = new RepositoryTickets();
    ManagerTickets manager = new ManagerTickets(repo);
    Ticket t1 = new Ticket(1, 6000, "SVO", "SVO", 145);
    Ticket t2 = new Ticket(2, 12000, "DME", "SVO", 120);
    Ticket t3 = new Ticket(3, 12300, "MRV", "DME", 225);
    Ticket t4 = new Ticket(4, 9000, "MRV", "DME", 225);
    Ticket t5 = new Ticket(5, 6000, "DME", "MRV", 225);
    Ticket t6 = new Ticket(6, 50000, "VKO", "YKS", 500);

    @Test
    public void shouldSortAndGiveIATA() {
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);

        Ticket[] actual = manager.searchBy("MRV", "DME");
        Ticket[] expected = {t4, t3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFound() {
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);

        Ticket[] actual = manager.searchBy("YKS", "MRV");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldToRemove() {
        repo.add(t1);
        repo.add(t2);
        repo.add(t3);
        repo.add(t4);
        repo.add(t5);
        repo.add(t6);

        repo.removeById(2);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {t1, t3, t4, t5, t6};

        assertArrayEquals(expected, actual);
    }
}
