import java.util.Arrays;

public class RepositoryTickets {
    // репозиторий для хранения информации о "Билетах" (добавить, удалить, получить набор билетов)
    protected Ticket[] tickets = new Ticket[0];

    // МЕТОД ДОБАВИТЬ
    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        // 1 - копируем из старого
        // 2 - начиная с самого первого элемента
        // 3 - копир в новый
        // 4 - начиная с самого первого элемента
        // 5 - столько элементов сколько есть в старом
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        // вычисление номера последней ячейки к-ая не заполнена (размер минус один) и кладём последним наш элемент
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    // МЕТОД УДАЛИТЬ
    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (id != ticket.getId()) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    // МЕТОД ПОЛУЧИТЬ НАБОР БИЛЕТОВ
    public Ticket[] findAll() {
        return tickets;
    }
}
