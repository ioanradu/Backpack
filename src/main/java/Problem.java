import java.util.*;

public class Problem {

    private List<Item> availableItems;
    private Backpack backpack;
    private Map<String, Integer> countEachTypeOfAvailableItems;
    private Map<String, Double> sumOfEveryItemValues;
    private Map<String, Double> averageOfEveryItemValues;

    public Problem() {
        availableItems = new ArrayList<>();
        countEachTypeOfAvailableItems = new HashMap<>();
        sumOfEveryItemValues = new HashMap<>();
        averageOfEveryItemValues = new HashMap<>();
    }

    public Map<String, Integer> getCountEachTypeOfAvailableItems() {
        return countEachTypeOfAvailableItems;
    }

    public void setCountEachTypeOfAvailableItems(Map<String, Integer> countEachTypeOfAvailableItems) {
        this.countEachTypeOfAvailableItems = countEachTypeOfAvailableItems;
    }

    public Map<String, Double> getSumOfEveryItemValues() {
        return sumOfEveryItemValues;
    }

    public void setSumOfEveryItemValues(Map<String, Double> sumOfEveryItemValues) {
        this.sumOfEveryItemValues = sumOfEveryItemValues;
    }

    public Map<String, Double> getAverageOfEveryItemValues() {
        return averageOfEveryItemValues;
    }

    public void setAverageOfEveryItemValues(Map<String, Double> averageOfEveryItemValues) {
        this.averageOfEveryItemValues = averageOfEveryItemValues;
    }

    public void copyAvailableItemsToCountEachTypeOfAvailableItems() {
        for (Item item : availableItems) {
            String key = item.getName();
            if (!countEachTypeOfAvailableItems.containsKey(key)) {
                countEachTypeOfAvailableItems.put(key, 1);
            } else {
                int value = countEachTypeOfAvailableItems.get(key);
                value++;
                countEachTypeOfAvailableItems.put(key, value);
            }
        }
    }

    public void calculateAndStoreTheSumValueOfEveryAvailableItem() {
        for (Item item : availableItems) {
            String key = item.getName();
            double value = item.getValue();
            double sumOfValues = 0;
            if (!sumOfEveryItemValues.containsKey(key)) {
                sumOfEveryItemValues.put(key, value);
            } else {
                double values = sumOfEveryItemValues.get(key);
                sumOfValues += values + value;
                sumOfEveryItemValues.put(key, sumOfValues);
            }
        }
    }

    public void calculateAndStoreTheAverageValueOfEveryAvailableItem() {
        for (String key : sumOfEveryItemValues.keySet()) {
            for (String keyAvailable : countEachTypeOfAvailableItems.keySet()) {
                if (key.equals(keyAvailable)) {
                    //System.out.println(key + "   " +sumOfEveryItemValues.get(key) + "  " + keyAvailable + "  " + countEachTypeOfAvailableItems.get(keyAvailable));
                    averageOfEveryItemValues.put(key, sumOfEveryItemValues.get(key) / countEachTypeOfAvailableItems.get(keyAvailable));
                }
            }
        }
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public Backpack getBackpack() {
        return backpack;
    }


    public void addAvailableItem(Item item) {
        this.availableItems.add(item);
    }

    public double getTotalWeightOfItemsBackpack() {
        return backpack.getTotalWeightOfItems();
    }

    public double remainAvailableCapacityOfItemsBackpack() {
        return backpack.remainAvailableCapacity();
    }

    public double getTotalValueOfItemsBackpack() {
        return backpack.getTotalValueOfItems();
    }

    public void moveItemsToBackpack() {
        for (int index = 0; index < availableItems.size(); index++) {
            Item currentItem = availableItems.get(index);
            backpack.add(currentItem);
        }
        removeAvailableItemsAfterCopyingToTheItemList();
    }

    public void moveProfitableItemsToBackpack() {
        Set<Item> itemSet = new TreeSet<>(availableItems);// copie lista availableItems intr-un Tree set pentru a putea fi sortate in functie de ce dorim
        // System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.add(iterator.next());
        }
        removeAvailableItemsAfterCopyingToTheItemList();
        /* for(int index = 0; index < itemSet.size(); index++){

        }*/
    }

    /* public void showItemListOfBackpack(){
       backpack.showItemList();
    }*/

    public void moveLightItemsToBackpack() { // light = usoare
        ItemComparatorByWeight comparator = new ItemComparatorByWeight();
        Set<Item> itemSet = new TreeSet<>(comparator);// copie lista availableItems intr-un Tree set pentru a putea fi sortate in functie de ce dorim
        itemSet.addAll(availableItems);
        // System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.add(iterator.next());
        }
        removeAvailableItemsAfterCopyingToTheItemList();
    }

    public void moveFractionOfItemsToBackpack() {
        Set<Item> itemSet = new TreeSet<>(availableItems);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.addFraction(iterator.next());
        }
        removeAvailableItemsAfterCopyingToTheItemList();
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public double getBackpackCapacity() {
        return backpack.getCapacity();
    }

    public int getNumberOfItemsInBackpack() {
        return backpack.getNumberOfItems();
    }

    public int getAvailableItemsSize() {
        return availableItems.size();
    }

    public void showItemListOfBackpack() {
        backpack.showItemList();
    }

    public void removeAvailableItemsAfterCopyingToTheItemList() {
        availableItems.removeAll(backpack.getItemList());
    }
}


