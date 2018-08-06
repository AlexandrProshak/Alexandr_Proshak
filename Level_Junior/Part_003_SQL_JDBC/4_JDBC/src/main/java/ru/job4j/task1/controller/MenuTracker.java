package ru.job4j.task1.controller;

import ru.job4j.task1.model.Item;

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
     * A field for an instance of a class TrackerDbImpl..
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
     *
     * @param input    is an ask interface.
     * @param tracker is an instance of a trackerArrayImpl.
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
        int i = 0;
        int index = 0;
        while (i < userAction.length) {
            this.range[i++] = index++;
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
        this.userAction[position++] = new AddItem(0, "Add new item to the tracker database");
        this.userAction[position++] = new MenuTracker.ShowItems(1, "Show all items");
        this.userAction[position++] = new EditItem(2, "Edit item by id");
        this.userAction[position++] = new DeleteItem(3, "Delete item");
        this.userAction[position++] = new FindItemById(4, "Find item by Id");
        this.userAction[position++] = new FindItemByName(5, "Find items by name");
    }

    /**
     * A method for select an action by user.
     *
     * @param key is a number of an action.
     */
    public void select(int key) {
        this.userAction[key].execute(this.input, this.tracker);
    }

    /**
     * A method for printing menu of actions.
     */
    public void showMenu() {
        for (UserAction action : this.userAction) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * A class for add an item to a tracker data base.
     */
    private class AddItem extends BaseAction {

        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         *
         * @param key  is a index of menu tracker data base.
         * @param name is an action's name.
         */
        private AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            item.setName(input.ask("Please enter the name: "));
            item.setDescription(input.ask("Please enter the description: "));
            item.setUserId((Integer.parseInt(input.ask("Please enter the user id: "))));
            item.setCategoryId((Integer.parseInt(input.ask("Please enter the category id: "))));
            item.setStateId((Integer.parseInt(input.ask("Please enter the state id: "))));
            tracker.add(item);
        }
    }

    /**
     * A class for displaying all items in the tracker data base.
     */
    private static class ShowItems extends BaseAction {

        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         *
         * @param key  is a index of menu tracker data base.
         * @param name is an action's name.
         */
        private ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] all = tracker.findAll();
            if (all.length > 0) {
                for (Item item : all) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("No items ... ");
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
         *
         * @param key  is a index of menu tracker data base.
         * @param name is an action's name.
         */
        protected EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            item.setId((Integer.parseInt(input.ask("Please enter the items id to update: "))));
            item.setName(input.ask("Please enter the new items name: "));
            item.setDescription(input.ask("Please enter the new description: "));
            item.setUserId((Integer.parseInt(input.ask("Please enter the user id: "))));
            item.setCategoryId((Integer.parseInt(input.ask("Please enter the category id: "))));
            item.setStateId((Integer.parseInt(input.ask("Please enter the state id: "))));
            tracker.update(item);
        }
    }

    /**
     * A class for remove an item by the id from a tracker data base.
     */
    class DeleteItem extends BaseAction {
        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         *
         * @param key  is a index of menu tracker data base.
         * @param name is an action's name.
         */
        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int idToRemove = Integer.parseInt(input.ask("Enter item's id to remove: "));
            tracker.delete(idToRemove);
        }
    }

    /**
     * A class searching item by id.
     */
    class FindItemById extends BaseAction {

        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         *
         * @param key  is a index of menu tracker data base.
         * @param name is an action's name.
         */
        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int itemId = Integer.parseInt(input.ask("Enter the item's id: "));
            Item item = tracker.findById(itemId);
            if (item.toString().contains("null")) {
                System.out.println("No items with given id ...");
            } else {
                System.out.println(item.toString());
            }
        }
    }

    /**
     * A class searching item by name.
     */
    class FindItemByName extends BaseAction {

        /**
         * A constructor with was declared in an abstract class
         * and must be redefined in an inheritor class.
         *
         * @param key  is a index of menu tracker data base.
         * @param name is an action's name.
         */
        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String searchName = input.ask("Enter the item's name: ");
            Item[] items = tracker.findByName(searchName);
            if (items.length > 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("No items with given name ...");
            }
        }
    }
}
