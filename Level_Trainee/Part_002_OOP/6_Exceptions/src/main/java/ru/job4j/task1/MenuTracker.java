package ru.job4j.task1;

/**
 * Class MenuTracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
     * An array of users actions.
     */
    private UserAction[] userAction = new UserAction[6];

    /**
     * A range of menu.
     */
    private int[] range = new int[userAction.length];

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
     * A getter and an initialization an array of a menu.
     * @return an array of menu's index.
     */
    public int[] getUserActionIndexes() {
        int index = 0;
        while (index < userAction.length) {
            this.range[index++] = index++;
        }
        return this.range;
    }

    /**
     * An index for an Action array to increase incrementally.
     */
    private int position = 0;

    /**
     * A method for registration actions.
     */
    public void fillActions() {
        this.userAction[position++] = new AddItem(0, "Add new item to the tracker");
        this.userAction[position++] = new ShowItems(1, "Show all items");
        this.userAction[position++] = new EditItem(2, "Edit item by id");
        this.userAction[position++] = new DeleteItem(3, "Delete item");
        this.userAction[position++] = new FindItemById(4, "Find item by Id");
    }

    /**
     * A method for add an action item to the tracker.
     * @param action is an instance of an action.
     */
    public void addAction(UserAction action) {
        this.userAction[position++] = action;
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
