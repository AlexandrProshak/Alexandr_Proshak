package ru.job4j.exceptions;

/**
 * Class ValidateInput.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
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
                System.out.println("Please enter valid date again.");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (Exception e) {
                System.out.println("Please check your input data and input again.");
            }
        } while (invalid);
        return value;
    }
}
