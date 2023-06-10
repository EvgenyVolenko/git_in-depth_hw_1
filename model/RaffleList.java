package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RaffleList implements Iterable<Toy> {

    private List<Toy> toys = new ArrayList<>();

    public RaffleList addToy(Toy newToy) {
        this.toys.add(newToy);
        return this;
    }

    public void dellToy(Toy clearToy) {
        Iterator<Toy> iterator = toys.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy == clearToy) {
                System.out.println("УДАЛЕНИЕ " + toy.toString());
                iterator.remove();
            }
        }
    }

    public int sizeList() {
        return toys.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Toy toy : toys) {
            res.append(toy)
                .append(String.format("Шанс выпадения в розыгрыше: %d | ", toy.getChance()))
                .append(String.format("Количество: %d |", toy.getCount()))
                .append("\n");
        }
        return res.toString();
    }

    @Override
    public Iterator<Toy> iterator() {
        return new Iterator<Toy>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                if (counter < toys.size())
                    return true;
                return false;
            }

            @Override
            public Toy next() {
                return toys.get(counter++);
            }
        };
    }

    public void SortList() {

        Collections.sort(toys);
    }

    public Toy Roulette() {

        Random rnd = new Random();

        int x = sizeList();

        int[] toyid = new int[x];
        int[] chance = new int[x];

        x = 0;

        for (Toy toy : this) {
            toyid[x] = toy.getId();
            chance[x] = toy.getChance();
            x++;
        }

        int count = IntStream.of(chance).sum();
        int index = rnd.nextInt(count);

        for (int i = 0; i < chance.length; i++) {
            index -= chance[i];
            if (index < 0) {
                for (Toy toy : this) {
                    if (toy.getId() == toyid[i]) {
                        toy.setCount(toy.getCount() - 1);
                        return toy;
                    }
                }
                break;
            }
        }
        return null;
    }
}
