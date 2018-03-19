package ru.job4j.bombermanv2.models.playground;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.bombermanv2.models.entities.Figure;

import java.util.concurrent.locks.ReentrantLock;

/**
 * The class Cell is a component of a field.
 * The cell includes a figure.
 */
@ThreadSafe
public class Cell extends ReentrantLock {

    /**
     * The volatile field indicates of the cell state.
     */
    private volatile boolean free;

    /**
     * The figure should be set on this cell.
     */
    @GuardedBy("itself")
    private Figure figure;

    /**
     * A constructor.
     */
    Cell() {
        this.free = true;
    }

    /**
     * A setter for a figure.
     * @param figure to be set on this cell.
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
        this.free = false;
    }

    /**
     * The method shows cell's state.
     * @return state.
     */
    public boolean isFree() {
        return free;
    }

    /**
     * The method returns figure on this cell.
     * @return figure.
     */
    @GuardedBy("itself")
    public Figure takeFigure() {
        Figure result = null;
        if (!free) {
            Figure fig = this.figure;
            this.figure = null;
            this.free = true;
            this.unlock();
            result = fig;
        }
        return result;
    }

    /**
     * The method shows name figure at current cell if it is present.
     * @return name.
     */
    public String showFigureName() {
        if (this.figure == null) {
            return "";
        } else {
            return figure.getName();
        }
    }

    @Override
    public String toString() {
        if (figure == null) {
            return "{ }";
        } else {
            return figure.toString();
        }
    }

}
