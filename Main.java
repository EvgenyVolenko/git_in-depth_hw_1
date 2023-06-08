import model.DrowingList;
import model.Toy;

public class Main {
    
    public static void main(String[] args) {
        
        DrowingList toysList = new DrowingList();

        toysList.addToy(new Toy(1, "Конструктор", 1, 10))
                .addToy(new Toy(2, "Мягкая игрушка", 2, 15))
                .addToy(new Toy(3, "Машинка", 3, 20))
                .addToy(new Toy(4, "Мяч", 1, 5))
                .addToy(new Toy(5, "Кукла", 4, 25));

        System.out.println("В розыгрыше находятся");
        System.err.println(toysList);
    }
}