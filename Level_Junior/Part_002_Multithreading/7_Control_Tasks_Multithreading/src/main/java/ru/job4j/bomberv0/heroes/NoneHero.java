package ru.job4j.bomberv0.heroes;

import ru.job4j.bomberv0.playground.Field;

/**
 * The class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class NoneHero extends Hero {

    /**
     * None name constant.
     */
    private static final String NONE_NAME = " ";

    /**
     * A constructor.
     * @param x coordinate.
     * @param y coordinate.
     * @param field game bord.
     */
    public NoneHero(int x, int y, Field field) {
        super(NONE_NAME, x, y, field);
    }

    @Override
    public String getName() {
        return NONE_NAME;
    }

    @Override
    public void move() {
        /*Not move*/
    }
}
