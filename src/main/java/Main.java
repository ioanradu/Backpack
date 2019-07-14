import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        /*Item item1 = new Sunglasses("ochelari1", 0.4, 200);
        Item item2 = new Sunglasses("ochelari2", 0.4, 200);
        Item item3 = new Sunglasses("ochelari3", 0.4, 200);
        Item item4 = new Sunglasses("ochelari4", 0.4, 200);
        Item item5 = new Sunglasses("ochelari5", 0.4, 200);
*/
        Problem problem = new Problem();
        problem.setBackpack(new Backpack(12));

       /* problem.addAvailableItem(item1);
        problem.addAvailableItem(item2);
        problem.addAvailableItem(item3);
        problem.addAvailableItem(item4);
        problem.addAvailableItem(item5);*/

        List<Item> generatedItems = Util.generateItems(100);
        problem.setAvailableItems(generatedItems);
        // Util.saveProblem(problem);// salveaza lista in problem.json

        // System.out.println(problem.getAvailableItems());
        problem.copyAvailableItemsToCountEachTypeOfAvailableItems();
        System.out.print("Available items and their quantity: " + problem.getCountEachTypeOfAvailableItems());
        System.out.println();

        problem.calculateAndStoreTheSumValueOfEveryAvailableItem();
        System.out.println("The sum of every item values: " + problem.getSumOfEveryItemValues());

        problem.calculateAndStoreTheAverageValueOfEveryAvailableItem();
        System.out.println("Available items and their average values: " + problem.getAverageOfEveryItemValues());
        System.out.println();

        // Cazul Sortat
        System.out.println("SORTATED BY PROFIT");
        problem.moveProfitableItemsToBackpack();
        displayToConsole(problem);

        // Cazul nesortat
        System.out.println("NOT SORTED");
        problem.setBackpack(new Backpack(12));//RESETAM RUCSACUL
        problem.moveItemsToBackpack();
        displayToConsole(problem);

        //Cazul obiecte usoare
        System.out.println("SORTED BY LIGHT OBJECTS");
        problem.setBackpack(new Backpack(12));//RESETAM RUCSACUL
        problem.moveLightItemsToBackpack();
        displayToConsole(problem);

        //Cazul obiecte fractionale
        System.out.println("FRACTION OF OBJECTS");
        problem.setBackpack(new Backpack(12));//RESETAM RUCSACUL
        problem.moveFractionOfItemsToBackpack();
        displayToConsole(problem);
    }

    private static void displayToConsole(Problem problem) {
        double totalWeightOfItemsInBackpack;
        double backpackCapacity;
        double totalValue;

        totalWeightOfItemsInBackpack = problem.getTotalWeightOfItemsBackpack();
        backpackCapacity = problem.getBackpackCapacity();
        totalValue = problem.getTotalValueOfItemsBackpack();

        System.out.println("Capacity: " + backpackCapacity + ", total weight in backpack: "
                + totalWeightOfItemsInBackpack + ", number of items in backpack: " + problem
                .getNumberOfItemsInBackpack());
        System.out.println("Total value: " + totalValue);
        System.out.println("The size of availableItems after moved items to itemList: " +
                problem.getAvailableItemsSize() + "\n");
    }
}
