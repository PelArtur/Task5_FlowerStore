package flower.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Item> items = new ArrayList<>();
    public List<Item> search(Filter filter){
        List<Item> foundItems = new ArrayList<>();
        for (Item item: items){
            if (filter.match(item)){
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
 }