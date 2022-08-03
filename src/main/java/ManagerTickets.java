import java.util.Arrays;

public class ManagerTickets {
    // менеджер поиска по аэропорту вылета и аэропорту прилёта (даты не учитывайть)
    private RepositoryTickets repo;

    public ManagerTickets(RepositoryTickets repository) { // конструктор принимает параметром репозиторий
        this.repo = repository;
    }


    public Ticket[] searchBy(String departureIATA, String arrivalIATA) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDepartureIATA().equals(departureIATA) && ticket.getArrivalIATA().equals(arrivalIATA)) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
//            else {
//                System.out.println("Упс, таких билетов нет");
//            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
