package model;

public class ToyMapper {
    
    public String map(Toy toy) {
        return String.format("%d:%s", toy.getId(), toy.getName());
    }

    public Toy map(String line) {
        String[] lines = line.split("\\:");
        return new Toy(Integer.parseInt(lines[0]), lines[1]);
    }
}
