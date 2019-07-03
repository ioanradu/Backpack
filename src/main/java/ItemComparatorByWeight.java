import java.util.Comparator;

public class ItemComparatorByWeight implements Comparator<Item> {

    @Override
    public int compare(Item firstItem, Item secondItem) {
        double firstItemWeight = firstItem.getWeight();
        double secondItemWeight = secondItem.getWeight();
        return Double.compare(firstItemWeight, secondItemWeight);
    }
}
