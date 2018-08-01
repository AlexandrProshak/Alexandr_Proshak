package ru.job4j.task4;

/**
 * Class Square.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("^^^").append("\n").append("^^^").append("\n").append("^^^");
        return sb.toString();
    }
}
