import controllers.WriteFile;
import model.PrizeList;
import model.RaffleList;
import model.Toy;

public class Main {

    public static void main(String[] args) {

        RaffleList toysList = new RaffleList();
        PrizeList pList = new PrizeList();

        String fname = "issuedToys.txt";
        
        Toy toyToPrize = null;
        int c = 10; // Количество розыгрышей
        int v = 5; // Количество выданных игрушек

        toysList.addToy(new Toy(7, "Конструктор", 1, 5))
                .addToy(new Toy(2, "Мягкая игрушка", 4, 20))
                .addToy(new Toy(3, "Машинка", 3, 20))
                .addToy(new Toy(4, "Мяч", 5, 30))
                .addToy(new Toy(5, "Кукла", 5, 25));

        toysList.SortList();

        System.out.println("В РОЗЫГРЫШЕ\n");
        System.err.println(toysList);

        for (Toy toy : toysList) {
            if (toy.getId() == 5) {
                toy.setChance(50);
                System.out.println("ИЗМЕНЕНА ВЕРОЯТНОСТЬ ВЫПАДЕНИЯ:\n" + toy + toy.getChance() + "\n");
            }
        }

        for (int i = 0; i < c; i++) {
            toyToPrize = toysList.Roulette();
            pList.addToy(toyToPrize);
            if (toyToPrize.getCount() == 0) {
                toysList.dellToy(toyToPrize);
            }
            if (toysList.sizeList() == 0) {
                System.out.println("ВСЕ ИГРУШКИ РАЗЫГРАНЫ!!!");
                break;
            }
        }

        System.out.println("ОСТАЛИСЬ:\n" + toysList);

        System.out.println("РАЗЫГРАНЫ:\n" + pList);

        for (int i = 0; i < v; i++) {
            toyToPrize = pList.dellToy();
            WriteFile.WrFile(fname, toyToPrize);
        }

        System.out.println("НЕ ВЫДАНЫ:\n" + pList);
    }
}