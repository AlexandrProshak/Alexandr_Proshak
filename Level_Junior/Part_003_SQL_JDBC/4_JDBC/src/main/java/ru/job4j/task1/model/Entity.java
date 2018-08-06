package ru.job4j.task1.model;

import java.util.Objects;

/**
 * The abstract class Entity contains a common field for others sub entities.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public abstract class Entity {

    /**
     * The primary key in the db.
     */
    private int id;

    /**
     * The name.
     */
    private String name;

    /**
     * The description.
     */
    private String description;

    /**
     * The constructor.
     * @param id of entity.
     * @param name of entity.
     * @param description of entity.
     */
    public Entity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * The constructor without parameters.
     */
    public Entity() { }

    /**
     * The getter for id.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * The setter for id.
     * @param id value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter for name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for the name.
     * @param name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter for the description.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * The setter for the description.
     * @param description value.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entity entity = (Entity) o;
        return id == entity.id && Objects.equals(name, entity.name) && Objects.equals(description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
