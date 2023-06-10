package model;

import java.util.Iterator;
import java.util.LinkedList;

public class PrizeList implements Iterable<Toy>{
    
    private LinkedList<Toy> toys = new LinkedList<>();

    public PrizeList addToy(Toy newToy) {
        this.toys.add(newToy);
        return this;
    }

    public Toy dellToy(){
        return toys.removeFirst();
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
}
