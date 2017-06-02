package ru.job4j.strategy;

/**
 * Class Paint.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public String draw(Shape shape) {
        return shape.pic();
    }
}
