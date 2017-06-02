package ru.job4j.encapsulation;

import java.util.Arrays;

/**
 * Class Tracker describes a wrapper of the item's array.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    /**
     * An array of items.
     */
    private Item[] items;

    /**
     * Thr last index of the added element.
     */
    private int position = 0;

    /**
     * A constructor for class Tracker.
     */
    public Tracker() {
        this.items = new Item[100];
        this.position = 0;
    }

    /**
     * A method add adds the item passed in the arguments
     * to the array of the Items.
     * @param item for add.
     * @return item.
     */
    public Item add(Item item) {
        this.items[position++] = item;
        return item;
    }

    /**
     * A method update replaces the cell into the array of items
     * passed in the arguments.
     * @param item for update.
     */
    public void update(Item item) {
        if (item != null) {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                    this.items[i] = item;
                    break;
                }
            }
        }
    }

    /**
     * A method delete assigns the cell of the items array to null
     * if the field id of passed item equals to the id in the items array.
     * @param item for delete.
     */
    public void delete(Item item) {
        if (item != null) {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                    this.items[i] = null;
                    break;
                }
            }
        }
    }

    /**
     * A method findAll returns copy of the array items without null elements.
     * @return copy of the array.
     */
    public Item[] findAll() {
        int index = 0;
        Item[] result = new Item[this.position];
        for (Item it : this.items) {
            if (it != null) {
                result[index++] = it;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * A method findByName returns copy of the array item where key == items.name.
     * If an array has not such a name than return null.
     * @param key name for searching in array.
     * @return returns copy of the array where key == items.name.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.items.length];
        int index = 0;
        for (Item item: this.items) {
            if (item != null && item.getName().equals(key)) {
                result[index++] = item;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * A method findById returns value of the element from the array of items in which id = items.id.
     * If such a id is absent - return null.
     * @param id for searching in array.
     * @return the value o elements
     */
    public Item findById(String id) {
        Item result = null;
        if (id != null) {
            for (Item item : this.items) {
                if (item != null && item.getId().equals(id)) {
                    result = item;
                    break;
                }
            }
        }
        return result;
    }
}

