package ru.job4j.bomberv1.playground;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.bomberv1.heroes.Figure;

import java.util.concurrent.locks.ReentrantLock;

/**
 * The class Cell is a component of a field.
 * The cell includes a figure.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@ThreadSafe
public class Cell extends ReentrantLock {

    /**
     * The field to which the current cell belongs.
     */
    private final Field board;

    /**
     * The absolute coordinate x.
     */
    private final int x;

    /**
     * The absolute coordinate x.
     */
    private final int y;

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
     * @param field current field.
     * @param x coordinate.
     * @param y coordinate.
     */
    public Cell(final Field field, final int x, final int y) {
        this.board = field;
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        if (figure == null) {
            return "{   }";
        } else {
            return figure.toString();
        }
    }

}
