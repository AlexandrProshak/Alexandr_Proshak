package ru.job4j.collections.generics.tracker;

import ru.job4j.abstractions.BaseAction;
import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;
import ru.job4j.exceptions.Input;
import ru.job4j.inner.UserAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MenuTracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    /**
     * A field for link of ask interface.
     */
    private Input input;
    /**
     * A field for an instance of a class Tracker..
     */
    private Tracker tracker;
    /**
     * A list of users actions.
     */
    private List<UserAction> userAction = new ArrayList<>();
    /**
     * A range of menu.
     */
    private List<Integer> range = new ArrayList<>();

    /**
     * A constructor of a class MenuTracker.
     * @param input is an ask interface.
     * @param tracker is an instance of a tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * A getter and an initialization a list of a menu.
     * @return a list of menu's index.
     */
    public List<Integer> getUserActionIndexes() {
        int index = 0;
        while (index < userAction.size()) {
            this.range.add(index++);
        }
        return this.range;
    }

    /**
     * A method for registration actions.
     */
    public void fillActions() {
        this.userAction.add(new AddItem(0, "Add new item to the tracker"));
        this.userAction.add(new MenuTracker.ShowItems(1, "Show all items"));
        this.userAction.add(new EditItem(2, "Edit item by id"));
        this.userAction.add(new DeleteItem(3, "Delete item"));
        this.userAction.add(new FindItemById(4, "Find item by Id"));
    }

    /**
     * A method for add an action item to the tracker.
     * @param action is an instance of an action.
     */
    public void addAction(UserAction action) {
        this.userAction.add(action);
    }

    /**
     * A method for select an action by user.
     * @param key is a number of an action.
     */
    public void select(int key) {
        //this.userAction[key].execute(this.input, this.tracker);
        this.userAction.get(key).execute(this.input, this.tracker);
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
    private class AddItem extends BaseAction {

        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         * @param key is a index of menu tracker.
         * @param name is an action's name.
         */
        private AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the name: ");
            String desc = input.ask("Please enter the description: ");
            tracker.add(new Item(name, desc));
        }
    }

    /**
     * A class for displaying all items in the tracker.
     */
    private static class ShowItems extends BaseAction {

        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         * @param key is a index of menu tracker.
         * @param name is an action's name.
         */
        private ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.format("%s - %s %s", item.getId(), item.getName(), "\n");
            }
        }
    }
}

/**
 * A class for edit item by id.
 */
class EditItem extends BaseAction {

    /**
     * A constructor with was declared in an abstract class
     * and must be redefined in an inheritor class.
     * @param key is a index of menu tracker.
     * @param name is an action's name.
     */
    protected EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String itemIdToUpdate = input.ask("Enter item's id to update: ");
        String name = input.ask("Enter new items name: ");
        String desc = input.ask("Enter new items description: ");
        String comment = input.ask("Add a comment ");
        Item itemToUpdate = new Item(name, desc);
        itemToUpdate.setComments(comment);
        itemToUpdate.setId(itemIdToUpdate);
        tracker.update(itemToUpdate);
    }
}

/**
 * A class for remove an item by the id from a tracker.
 */
class DeleteItem extends BaseAction {

    /**
     * A constructor with was declared in an abstract class
     * and must be redefined in an inheritor class.
     * @param key is a index of menu tracker.
     * @param name is an action's name.
     */
    protected DeleteItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String itemIdToRemove = input.ask("Enter item's id to remove: ");
        tracker.delete(tracker.findById(itemIdToRemove));
    }
}

/**
 * A class searching item by id.
 */
class FindItemById extends BaseAction {

    /**
     * A constructor with was declared in an abstract class
     * and must be redefined in an inheritor class.
     * @param key is a index of menu tracker.
     * @param name is an action's name.
     */
    protected FindItemById(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String itemId = input.ask("Enter the item's id: ");
        Item item = tracker.findById(itemId);
        System.out.println(item);
    }
}
