package ru.job4j.bombermanv1.bomberman.heroes;

import ru.job4j.bombermanv1.bomberman.playground.Field;

/**
 * The abstract class Figure.
 */
public abstract class Figure implements Runnable {

    /**
     * The figure's name.
     */
    private final String name;

    /**
     * The alive flag.
     */
    private volatile boolean alive;

    /**
     * The current coordinate x.
     */
    private int x;

    /**
     * The current coordinate y.
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
    public Figure(final String name, final int x, final int y, final Field field)  {
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
     * The setter for the alive field.
     * @param status of figure.
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * The getter for name.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        this.setAlive(this.field.setFigureOnBoard(this, this.x, this.y));
        while (this.alive) {
            this.move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "{ " + name + " }";
    }

    /**
     * The abstract method move describes different movement of the subclasses' instances.
     */
    protected abstract void move();
}