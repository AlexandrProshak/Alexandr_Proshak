package ru.job4j.inner;

import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;
import ru.job4j.polymorphism.Input;

/**
 * Class MenuTracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * A field for link of input interface.
     */
    private Input input;
    /**
     * A field for an instance of a class Tracker..
     */
    private Tracker tracker;
    /**
     * An array of users actions.
     */
    private UserAction[] userAction = new UserAction[6];

    /**
     * A constructor of a class MenuTracker.
     * @param input is an input interface.
     * @param tracker is an instance of a tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * A method for registration actions.
     */
    public void fillActions() {
        this.userAction[0] = new AddItem();
        this.userAction[1] = new MenuTracker.ShowItems();
        this.userAction[2] = new EditItem();
        this.userAction[3] = new DeleteItem();
        this.userAction[4] = new FindItemById();
        this.userAction[5] = new FindItemByName();
    }

    /**
     * A method for select an action by user.
     * @param key is a number of an action.
     */
    public void select(int key) {
        this.userAction[key].execute(this.input, this.tracker);
    }

    /**
     * A method for printing menu of actions.
     */
    public void showMenu() {
        for (UserAction action: this.userAction) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * A class for add an item to a tracker.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.input("Please enter the name: ");
            String desc = input.input("Please enter the description: ");
            tracker.add(new Item(name, desc));

        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Add new item to the tracker");
        }
    }

    /**
     * A class for displaying all items in the tracker.
     */
    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.format("%s - %s %s", item.getId(), item.getName(), "\n");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Show all items");
        }
    }
}

/**
 * A class for edit item by id.
 */
class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String itemIdToUpdate = input.input("Enter item's id to update: ");
        String name = input.input("Enter new items name: ");
        String desc = input.input("Enter new items description: ");
        String comment = input.input("Add a comment ");
        Item itemToUpdate = new Item(name, desc);
        itemToUpdate.setComments(comment);
        itemToUpdate.setId(itemIdToUpdate);
        tracker.update(itemToUpdate);
    }

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), "Edit item by id");
    }
}

/**
 * A class for remove an item by the id from a tracker.
 */
class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String itemIdToRemove = input.input("Enter item's id to remove: ");
        tracker.delete(tracker.findById(itemIdToRemove));
    }

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), "Delete item");
    }
}

/**
 * A class searching item by id.
 */
class FindItemById implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String itemId = input.input("Enter the item's id: ");
        Item item = tracker.findById(itemId);
        System.out.println(item);
    }

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), "Find item by Id");

    }
}

/**
 * A class searching item by name.
 */
class FindItemByName implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String searchName = input.input("Enter the item's name: ");
        Item[] itemsName = tracker.findByName(searchName);
        for (Item itName : itemsName) {
            System.out.format("%s - %s. %s", itName.getId(), itName.getName(), "\n");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), "Find items by name");
    }
}