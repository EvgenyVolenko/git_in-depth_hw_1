package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DrowingList implements Iterable<Toy>{
    
    private List<Toy> toys = new ArrayList<>();

    public DrowingList addToy(Toy newToy) {
        this.toys.add(newToy);
        return this;
    }

    public void dellToy(Toy clearToy) {
        Iterator<Toy> iterator = toys.iterator();
        while(iterator.hasNext()){
            Toy toy = iterator.next();
            if (toy == clearToy) {
                System.out.println("УДАЛЕНИЕ " + toy.toString());
              iterator.remove();
            }
        }
    }

    public int sizeList(){
        return toys.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Toy toy : toys) {
            res.append(toy)
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

    public void Roulette(int a) {

        Random rnd = new Random();

        Collections.sort(toys);
    
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

        for (int randomNumsCount = 0; randomNumsCount < a; randomNumsCount++) {
            
            int index = rnd.nextInt(count);

            for (int i = 0; i < chance.length; i++) {
                index -= chance[i];
                if(index < 0) {
                    System.out.println("Случайное число: " + toyid[i]);
                    break;
                }
            }
        }
    }
}
