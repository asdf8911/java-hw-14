import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String departureIATA;
    private String arrivalIATA;
    private int timeInMinutes;

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getDepartureIATA() {
        return departureIATA;
    }

    public String getArrivalIATA() {
        return arrivalIATA;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDepartureIATA(String departureIATA) {
        this.departureIATA = departureIATA;
    }

    public void setArrivalIATA(String arrivalIATA) {
        this.arrivalIATA = arrivalIATA;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public Ticket(int id, int cost, String departureIATA, String arrivalIATA, int timeInMinutes) {
        this.id = id;
        this.cost = cost;
        this.departureIATA = departureIATA;
        this.arrivalIATA = arrivalIATA;
        this.timeInMinutes = timeInMinutes;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && cost == ticket.cost && timeInMinutes == ticket.timeInMinutes && Objects.equals(departureIATA, ticket.departureIATA) && Objects.equals(arrivalIATA, ticket.arrivalIATA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, departureIATA, arrivalIATA, timeInMinutes);
    }
}
