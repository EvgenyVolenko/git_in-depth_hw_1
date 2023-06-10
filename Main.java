import model.DrowingList;
import model.Toy;

public class Main {
    
    public static void main(String[] args) {
        
        DrowingList toysList = new DrowingList();

        toysList.addToy(new Toy(7, "Конструктор", 1, 5))
                .addToy(new Toy(2, "Мягкая игрушка", 4, 20))
                .addToy(new Toy(3, "Машинка", 3, 20))
                .addToy(new Toy(4, "Мяч", 5, 30))
                .addToy(new Toy(5, "Кукла", 5, 25));

        System.out.println("В розыгрыше находятся\n");
        // System.err.println(toysList);

        // for (Toy toy : toysList) {
        //     if (toy.getName().equals("Конструктор")) {
        //         toysList.dellToy(toy);
        //     }
        // }

        // for (Toy toy : toysList) {
        //     if (toy.getId() == 5) {
        //         toy.setChance(50);
        //     }
        // }

        // System.err.println(toysList);
        toysList.Roulette(10);
    }
}