import java.util.ArrayList;
import java.util.List;

public class Toy {
    private Integer id;
    public String name;
    public Integer chance;

    public Integer count;

    public Toy(Integer id, String name, Integer chance, Integer count) {
        this.id = id;
        this.name = name;
        this.chance = chance;
        this.count = count;
    }

    public Toy() {
    }

    public Integer getChance() {
        return chance;
    }

    public Integer getCount() {
        return count;
    }

    /**
     * @param id     Integer[] отвечающий за номер игрушки
     * @param name   String[] отвечающий за название игрушки
     * @param chance Integer[] отвечающий за шанс выпадения игрушки
     * @param count  Integer[] отвечающий за количество игрушек опереденного вида
     * @return List<Toy> список всех игрушек с их параметрами
     * @apiNote Создает список призов из массивов
     */
    public static List<Toy> createToys(Integer[] id, String[] name, Integer[] chance, Integer[] count) {
        List<Toy> ourToys = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            ourToys.add(new Toy(id[i], name[i], chance[i], count[i]));
        }
        return ourToys;
    }
}
