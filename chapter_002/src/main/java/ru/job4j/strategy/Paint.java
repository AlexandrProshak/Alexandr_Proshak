package ru.job4j.strategy;

/**
 * Class Paint.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * A method is drawing a shape.
     * @param shape is a parameter for drawing.
     * @return a line of the shape.
     */
    public String draw(Shape shape) {
        return shape.pic();
    }
}
