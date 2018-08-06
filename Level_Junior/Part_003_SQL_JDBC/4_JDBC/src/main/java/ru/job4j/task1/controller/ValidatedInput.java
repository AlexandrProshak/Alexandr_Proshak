package ru.job4j.task1.controller;

import ru.job4j.task1.exception.MenuOutException;

/**
 * Class ValidatedInput.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ValidatedInput extends ConsoleInput {

    /**
     * A method for user input with a validation.
     *
     * @param ask   a parameter for a method.
     * @param range is an array of a menu's indexes.
     * @return index of the menu.
     */
    @Override
    public int ask(String ask, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(ask, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid date.");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (Exception e) {
                System.out.println("Please check your input data and input again.");
            }
        } while (invalid);
        return value;
    }
}
