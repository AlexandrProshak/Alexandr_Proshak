package ru.job4j.task3;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Iterator;

/**
 * Te thread safe list.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @param <E> generic parameter.
 */
@ThreadSafe
public class MyThreadSafeList<E> implements SimpleContainer<E> {

    /**
     * A field for storing any implementation of the SimpleList interface.
     */
    @GuardedBy("mutex")
    private final SimpleContainer<E> list;

    /**
     * A private lock.
     */
    private final Object mutex = new Object();

    /**
     * A constructor of a class.
     * @param list an implementation of SimpleContainer interface.
     */
    public MyThreadSafeList(SimpleContainer<E> list) {
        this.list = list;
    }

    @GuardedBy("mutex")
    @Override
    public void add(E value) {
        synchronized (mutex) {
            list.add(value);
        }

    }

    @GuardedBy("mutex")
    @Override
    public E get(int index) {
        synchronized (mutex) {
            return this.list.get(index);
        }
    }

    @GuardedBy("mutex")
    @Override
    public Iterator<E> iterator() {
        synchronized (mutex) {
            return this.copy().iterator();
        }
    }

    @GuardedBy("mutex")
    @Override
    public SimpleContainer copy() {
        synchronized (mutex) {
            return this.list.copy();
        }
    }
}
