package ru.job4j.polymorphism;

import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;

/**
 * Class Action provides a performance of trackers operations.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Action {
    /**
     * A method execute performs trackers operations.
     * @param input is input interface.
     * @param tracker is an instance of the class Tracker.
     * @param choice is a number of user's choice.
     * @return false for exit and an incorrect users enter.
     */
    public boolean execute(Input input, Tracker tracker, int choice) {
        boolean result = false;
        switch (choice) {
            // add an items to the tracker.
            case 0:
                String itemName = input.input("Enter your name please: ");
                String itemDesc = input.input("Enter the item's description: ");
                tracker.add(new Item(itemName, itemDesc));
                result = true;
                break;
            //show all items from the tracker without null elements.
            case 1:
                Item[] items = tracker.findAll();
                System.out.println("All items by id:");
                for (Item item : items) {
                    System.out.println(item.getId());
                }
                result = true;
                break;
            //update item.
            case 2:
                String itemIdToUpdate = input.input("Enter item's id to update: ");
                String name = input.input("Enter new items name: ");
                String desc = input.input("Enter new items description: ");
                String comment = input.input("Add a comment ");
                Item itemToUpdate = new Item(name, desc);
                itemToUpdate.setComments(comment);
                itemToUpdate.setId(itemIdToUpdate);
                tracker.update(itemToUpdate);
                result = true;
                break;
            //delete item by id.
            case 3:
                String itemIdToRemove = input.input("Enter item's id to remove: ");
                tracker.delete(tracker.findById(itemIdToRemove));
                result = true;
                break;
            //return item by id.
            case 4:
                String itemId = input.input("Enter the item's id: ");
                Item item = tracker.findById(itemId);
                System.out.println(item);
                result = true;
                break;
            //return item by name.
            case 5:
                String searchName = input.input("Enter the item's name: ");
                Item[] itemsName = tracker.findByName(searchName);
                for (Item itName : itemsName) {
                    System.out.println(itName);
                }
                result = true;
                break;
            //return false to exit.
            case 6:
                result = false;
                break;
            //for an incorrect enter.
            default:
                result = false;
                break;
        }
        return result;
    }
}
