import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private double capacity;
    private List<Item> itemList;

    public Backpack(double capacity) {
        this.capacity = capacity;
        itemList = new ArrayList<Item>();
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotalWeightOfItems() {
        double sum = 0;
        for (Item item : itemList) {
            sum += item.getWeight();
        }
        return sum;
    }

    public double remainAvailableCapacity() {
        return capacity - getTotalWeightOfItems();
    }


    public double getTotalValueOfItems() {
        double sumOfValue = 0;
        for (Item item : itemList) {
            sumOfValue += item.getValue();
        }
        return sumOfValue;
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public boolean add(Item item) {
        if ((remainAvailableCapacity() >= item.getWeight())) {
            itemList.add(item);
            return true;
        }
        return false;
    }

    public boolean addFraction(Item item) {
        double availableCapacity = remainAvailableCapacity();
        if (availableCapacity == 0) {
            return false;
        }
        if ((remainAvailableCapacity() >= item.getWeight())) {
            itemList.add(item);
            return true;
        } else {
            Item fractionItem = new Item(item.getName(), availableCapacity, availableCapacity * item.getValue() / item.getWeight());
            itemList.add(fractionItem);
            return true;
        }
    }
}

