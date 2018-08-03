package ru.job4j.task2;

/**
 * Class Base.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
