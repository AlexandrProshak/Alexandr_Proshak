package ru.job4j.waitnotifynotifyall.task5;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The class Model.
 */
public class Model {
    /**
     * The current model's id.
     */
    private final long id;
    /**
     * The current model's name.
     */
    private String name;
    /**
     * The change version of current model's .
     */
    private volatile AtomicInteger version;

    /**
     * The constructor.
     * @param name of model.
     * @param id of model.
     */
    public Model(final long id, final String name) {
        this.id = id;
        this.name = name;
        this.version = new AtomicInteger(0);
    }

    /**
     * The getter for version.
     * @return current version.
     */
    public AtomicInteger getVersion() {
        return version;
    }

    /**
     * The setter for version.
     * @param version to be set.
     */
    public void setVersion(AtomicInteger version) {
        this.version = version;
    }

    /**
     * The getter for id.
     * @return id.
     */
    public long getId() {
        return id;
    }

    /**
     * The getter for name.
     * @return current name.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for name.
     * @param name to be set.
     */
    public void setName(String name) {
        this.name = name;
        version.getAndIncrement();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model model = (Model) o;
        return id == model.id && Objects.equals(name, model.name) && Objects.equals(version, model.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version);
    }
}