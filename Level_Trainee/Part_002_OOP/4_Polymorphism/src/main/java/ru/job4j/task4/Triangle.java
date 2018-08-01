package ru.job4j.task4;

/**
 * Class Triangle.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Triangle implements Shape {

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ^ ").append("\n").append("^^^");
        return sb.toString();
    }
}
