package ru.job4j.bombermanv2.models.entities;

import ru.job4j.bombermanv2.controllers.GameController;
import ru.job4j.bombermanv2.models.playground.Field;

import java.util.Random;

/**
 * The abstract class Figure.
 */
public abstract class Figure implements Runnable {

    /**
     * The figure's name.
     */
    private final String name;

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
     * The getter for the controller.
     * @return controller.
     */
    GameController getController() {
        return controller;
    }

    /**
     * The game's controller.
     */
    private final GameController controller;

    /**
     * A constructor.
     * @param controller of the game.
     * @param name of the figure.
     * @param x coordinate.
     * @param y coordinate.
     * @param field an instance of the board.
     */
    protected Figure(final GameController controller, final String name, final int x, final int y, final Field field)  {
        this.controller = controller;
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
    void setX(int x) {
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
    void setY(int y) {
        this.y = y;
    }

    /**
     * The getter for field.
     * @return field.
     */
    Field getField() {
        return field;
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
        this.field.setFigureOnBoard(this, this.x, this.y);
        while (controller.isGame()) {
            this.move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The method returns new coordinate.
     * @param coordinate start coordinate.
     * @return new coordinate.
     */
    static int newCoordinate(int coordinate) {
        int[] row = {coordinate - 1, coordinate, coordinate + 1};
        return row[new Random().nextInt(row.length)];
    }

    @Override
    public String toString() {
        return "{" + name + "}";
    }

    /**
     * The abstract method move describes different movement of the subclasses' instances.
     */
    protected abstract void move();
}