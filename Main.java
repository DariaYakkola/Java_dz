import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Integer[] id = {1, 2, 3};
        String[] name = {"Конструктор", "Робот", "Кукла"};
        Integer[] chance = {20, 20, 60};
        Integer[] count = {2, 2, 6};
        Toy toy = new Toy();
        List<Toy> ourToys = toy.createToys(id, name, chance, count);
        Service service = new Service();
        Queue<Toy> queueToys = service.queueToys(ourToys);
        service.lottery(ourToys);
    }
}