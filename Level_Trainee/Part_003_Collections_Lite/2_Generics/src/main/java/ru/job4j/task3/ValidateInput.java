package ru.job4j.task3;

import java.util.List;

/**
 * Class ValidateInput.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ValidateInput implements Input {

    /**
     * The field stores realisation of Input interface.
     */
    private final Input input;

    /**
     * The constructor.
     * @param input parameter.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * The method ask decorates.
     * @param ask a parameter for a method.
     * @return a menu's string.
     */
    @Override
    public String ask(String ask) {
        return this.input.ask(ask);
    }

    /**
     * A method for user input with a validation.
     * @param question a parameter for a method.
     * @param range is a list of a menu's indexes.
     * @return index of the menu.
     */
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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
