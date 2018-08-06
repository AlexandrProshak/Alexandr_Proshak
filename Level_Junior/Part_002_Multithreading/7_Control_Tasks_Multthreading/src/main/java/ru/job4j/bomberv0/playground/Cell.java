package ru.job4j.bomberv0.playground;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.bomberv0.heroes.Hero;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The class Cell is a component of a field.
 * The cell includes a figure.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@ThreadSafe
public class Cell implements Lock {

    /**
     * A private ReentrantLock.
     */
    private final Lock privateLock = new ReentrantLock();

    /**
     * The figure should be set on this cell.
     */
    private Hero figure;

    /**
     * A constructor.
     * @param hero to be set.
     */
    public Cell(Hero hero) {
        this.figure = hero;
    }

    /**
     * Getter for a figure on this cell.
     * @return figure.
     */
    public Hero getFigure() {
        return figure;
    }

    /**
     * A setter for a figure.
     * @param figure to be set on this cell.
     */
    public void setFigure(Hero figure) {
        this.figure = figure;
    }

    @Override
    public void lock() {
        this.privateLock.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.privateLock.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        return this.privateLock.tryLock();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return this.privateLock.tryLock(time, unit);
    }

    @Override
    public void unlock() {
        this.privateLock.unlock();
    }

    @Override
    public Condition newCondition() {
        return this.privateLock.newCondition();
    }
}
