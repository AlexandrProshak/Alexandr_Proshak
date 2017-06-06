package ru.job4j.strategy;

/**
 * Class Triangle.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ^ ").append("\n").append("^^^");
        return sb.toString();
    }
}
