package model;

import java.util.ArrayList;
import java.util.List;

public class PrizeList {
    
    private List<Toy> toys = new ArrayList<>();

    public PrizeList addToy(Toy newToy) {
        this.toys.add(newToy);
        return this;
    }

    public void dellToy(){
        toys.remove(0);
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
