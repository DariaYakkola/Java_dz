import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Service {

    /**
     * @param ourToys созданый список игрушек List<Toy>
     * @return общую очередь из списка игрушек
     * @apiNote Метод создает очередь из списка игрушек
     */
    public Queue<Toy> queueToys(List<Toy> ourToys) {
        PriorityQueue<Toy> toysSort = new PriorityQueue<>(ourToys.size(), Comparator.comparingInt(Toy::getChance));
        for (int i = 0; i < ourToys.size(); i++) {
            toysSort.offer(ourToys.get(i));
        }
        Queue<Toy> generalQueue = new LinkedList<>();
        while (!toysSort.isEmpty()) {
            generalQueue.offer(toysSort.poll());
        }
        return generalQueue;
    }

    /**
     * @param ourToys список призов
     * @apiNote На основе выпадения рандомных чисел записывает результаты розыгрыша
     */
    public void lottery(List<Toy> ourToys) {
        try (PrintWriter writer = new PrintWriter(new File("result.txt"))) {
            Random random = new Random();
            int count1 = ourToys.get(0).getCount();
            int count2 = ourToys.get(1).getCount();
            int count3 = ourToys.get(2).getCount();
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(10);
                System.out.println(randomNumber);
                if (((randomNumber == 1) || (randomNumber == 2) || (randomNumber == 3))
                        && (count3 > 0)) {
                    writer.println("id игрушки: " + 3);
                    count3 = count3 - 1;
                } else if (((randomNumber == 4) || (randomNumber == 5) || (randomNumber == 0))
                        && (count3 > 0)) {
                    writer.println("id игрушки: " + 3);
                    count3 = count3 - 1;
                } else if ((randomNumber == 7 || randomNumber == 6) && (count1 > 0)) {
                    writer.println("id игрушки: " + 1);
                    count1 = count1 - 1;
                } else if ((randomNumber == 9 || randomNumber == 8) && (count2 > 0)) {
                    writer.println("id игрушки: " + 2);
                    count2 = count2 - 1;
                } else {
                    writer.println("Такие игрушки закончились!");
                    i = i - 1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}