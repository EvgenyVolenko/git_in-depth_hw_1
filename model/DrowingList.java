package model;

import java.util.ArrayList;
import java.util.List;

public class DrowingList {
    
    public final String addToy = null;
    private List<Toy> toys = new ArrayList<>();

    public DrowingList addToy(Toy newToy) {
        this.toys.add(newToy);
        return this;
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
}
