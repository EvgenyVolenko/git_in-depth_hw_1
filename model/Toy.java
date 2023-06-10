package model;

public class Toy implements Comparable<Toy>{

    protected int id;
    protected String name;
    protected int count;
    protected int chance;

    public Toy(int id, String name, int count, int chance) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chance = chance;
    }

    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        
        StringBuilder res = new StringBuilder();
        res.append(String.format("| Идентификатор: %d | ", this.id))
           .append(String.format("Игрушка: %s | ", this.name));

        return res.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    @Override
    public int compareTo(Toy o) {
        return this.id - o.id;
    }
}
