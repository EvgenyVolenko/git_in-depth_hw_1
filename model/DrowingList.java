package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
