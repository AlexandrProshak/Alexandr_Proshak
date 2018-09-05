package ru.job4j.bomberv0.heroes;

import ru.job4j.bomberv0.playground.Field;

/**
 * The class Hero.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public abstract class Hero implements Runnable {

    /**
     * The figure's name.
     */
    private final String name;

    /**
     * The alive flag.
     */
    private volatile boolean alive;

    /**
     * X coordinate.
     */
    private int x;

    /**
     * Y coordinate.
     */
    private int y;

    /**
     * The game board.
     */
    private final Field field;

    /**
     * A constructor.
     * @param name of the figure.
     * @param x coordinate.
     * @param y coordinate.
     * @param field an instance of the board.
     */
    public Hero(final String name, final int x, final int y, final Field field)  {
        this.name = name;
        this.x = x;
        this.y = y;
        this.field = field;
    }

    /**
     * The getter for x.
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * The setter for x.
     * @param x parameter.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * The getter for y.
     * @return y.
     */
    public int getY() {
        return y;
    }

    /**
     * The setter for y.
     * @param y parameter.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * The getter for field.
     * @return field.
     */
    public Field getField() {
        return field;
    }

    /**
     * The setter for alive field.
     */
    public void setAlive() {
        this.alive = true;
    }

    /**
     * The getter for name.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * The method set flag alive in to false state.
     */
    public void killHero() {
        this.alive = false;
    }

    @Override
    public void run() {
        while (true) {
            if (this.alive) {
                this.move();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }

    /**
     * The abstract method moves the hero.
     */
    protected abstract void move();
}