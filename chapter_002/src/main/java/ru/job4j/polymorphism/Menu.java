package ru.job4j.polymorphism;

import java.io.IOException;

/**
 * Class Menu.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Menu {

    /**
     * An array of menu.
     */
    private String[] menu;

    /**
     * A constructor for class menu.
     */
    public Menu() {
        this.menu = new String[]{
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
     * A method showMenu prints menu.
     * @return users answer.
     * @throws IOException if something was wrong.
     */
    public String showMenu() throws IOException {
        System.out.println("Enter the number of the action below");
        System.out.println();
        for (String menuItem : this.menu) {
            System.out.println(menuItem);
        }
        System.out.println();
        return new ConsoleInput().consoleInput("Select: ");
    }
}
