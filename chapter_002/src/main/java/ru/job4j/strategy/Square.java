package ru.job4j.strategy;

/**
 * Class Square.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    @Override
    public String pic() {
        return "I am a square";
    }
}
