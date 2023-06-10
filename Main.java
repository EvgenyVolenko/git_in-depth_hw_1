import model.PrizeList;
import model.RaffleList;
import model.Toy;

public class Main {

    public static void main(String[] args) {

        RaffleList toysList = new RaffleList();
        PrizeList pList = new PrizeList();
        Toy toyToPrize = null;
        int c = 20; // Количество розыгрышей

        toysList.addToy(new Toy(7, "Конструктор", 1, 5))
                .addToy(new Toy(2, "Мягкая игрушка", 4, 20))
                .addToy(new Toy(3, "Машинка", 3, 20))
                .addToy(new Toy(4, "Мяч", 5, 30))
                .addToy(new Toy(5, "Кукла", 5, 25));

        toysList.SortList();

        System.out.println("В розыгрыше находятся\n");
        System.err.println(toysList);

        for (Toy toy : toysList) {
            if (toy.getId() == 5) {
                toy.setChance(50);
            }
        }

        for (int i = 0; i < c; i++) {
            toyToPrize = toysList.Roulette();
            if (toyToPrize == null) {
                System.out.println("ВСЕ ИГРУШКИ РАЗЫГРАНЫ!!!");
            } else if (toyToPrize.getCount() == 0) {
                toysList.dellToy(toyToPrize);
            } else {
                pList.addToy(toyToPrize);
            }
        }

        System.err.println("Остались: " + toysList);
        
        System.out.println(pList);
    }
}