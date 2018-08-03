package ru.job4j.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Tracker describes a wrapper of the item's array.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Tracker {

    /**
     * A List of items.
     */
    private List<Item> items;

    /**
     * A constructor for class Tracker.
     */
    public Tracker() {
        this.items = new ArrayList<>(100);
    }

    /**
     * A method add adds the item passed in the arguments
     * to the list of the Items.
     * @param item for add.
     * @return item.
     */
    public Item add(Item item) {
        this.items.add(item);
        return item;
    }

    /**
     * A method update replaces the cell in the list of items
     * passed in the arguments.
     * @param item for update.
     */
    public void update(Item item) {
        if (item != null) {
            for (Item it: this.items) {
                if (it != null && it.getId().equals(item.getId())) {
                    this.items.set(this.items.indexOf(it), item);
                    break;
                }
            }
        }
    }

    /**
     * A method delete deletes an item from the list
     * if the field id of passed item equals to the id in the items list.
     * @param item for delete.
     */
    public void delete(Item item) {
        this.items.removeIf(it -> it.getId().equals(item.getId()));
//        if (item != null) {
//            for (Item it: this.items) {
//                if (it != null && it.equals(item)) {
//                    this.items.remove(it);
//                    break;
//                }
//            }
//        }
    }

    /**
     * A method findAll returns all elements from list.
     * @return list.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        Iterator<Item> iterator = this.items.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    /**
     * A method findByName returns copy of the list items where key == items.name.
     * If a list has not such a name than return null.
     * @param key name for searching in the list.
     * @return returns a list where key == items.name.
     */
    public List<Item> findByName(String key) {
        List<Item> result = this.items.parallelStream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
//        List<Item> result = null;
//        List<Item> nameList = new ArrayList<>();
//        if (key != null) {
//            for (Item it : this.items) {
//                if (it != null && it.getName().equals(key)) {
//                    nameList.add(it);
//                }
//            }
//            if (!nameList.isEmpty()) {
//                result = nameList;
//            }
//        }
        return result;
    }

    /**
     * A method findById returns item of the element from the list of items in which id = items.id.
     * If such an id is absent - returns null.
     * @param id for searching in the list.
     * @return the value an item
     */
    public Item findById(String id) {
        Item result = this.items.parallelStream()
                .filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
//        Item result = null;
//        if (id != null) {
//            for (Item item : this.items) {
//                if (item != null && item.getId().equals(id)) {
//                    result = item;
//                    break;
//                }
//            }
//        }
        return result;
    }
}

