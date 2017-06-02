package ru.job4j.polymorphism;

import java.io.IOException;

/**
 * Class MenuTracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    /**
     * An array of actions.
     */
    private String[] actions;

    /**
     * A constructor for class actions.
     */
    public MenuTracker() {
        this.actions = new String[]{
                "0. Add new Item",
                "1. Show all items",
                "2. Edit item",
                "3. Delete item",
                "4. Find item by Id",
                "5. Find items by name",
                "6. Exit Program"
        };
    }

    /**
     * A method show prints actions.
     * @throws IOException if something was wrong.
     */
    public void show() throws IOException {
        System.out.println("____________________________________");
        System.out.println("Enter the number of the action below");
        System.out.println();
        for (String menuItem : this.actions) {
            System.out.println(menuItem);
        }
        System.out.println();
    }
}
