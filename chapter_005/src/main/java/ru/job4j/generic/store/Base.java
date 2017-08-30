package ru.job4j.generic.store;

/**
 * Class Base.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {

    /**
     * Id.
     */
    private String id;

    /**
     * Constructor.
     * @param id parameter.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Gets id.
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets id.
     * @param id to set.
     */
    public void setId(String id) {
        this.id = id;
    }
}
