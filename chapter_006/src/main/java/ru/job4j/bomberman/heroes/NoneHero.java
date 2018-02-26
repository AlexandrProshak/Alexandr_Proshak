package ru.job4j.bomberman.heroes;

import ru.job4j.bomberman.playground.Field;

/**
 * The class.
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
