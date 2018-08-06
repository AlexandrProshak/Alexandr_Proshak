package ru.job4j.task1.model;

import java.util.Date;
import java.util.Objects;

/**
 * The class Item.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Item extends Entity {

    /**
     * The date of creating.
     */
    private long creationDate;

    /**
     * The user who is responding.
     */
    private int userId;

    /**
     * The category of an item.
     */
    private int categoryId;

    /**
     * The current state of an item.
     */
    private int stateId;

    /**
     * Te constructor with parameters.
     * @param id of an item in the database.
     * @param name of an item.
     * @param description of an item.
     * @param userId who is responding.
     * @param categoryId of an item.
     * @param stateId of an item.
     */
    public Item(int id, String name, String description, int userId, int categoryId, int stateId) {
        super(id, name, description);
        this.creationDate = new Date().getTime();
        this.userId = userId;
        this.categoryId = categoryId;
        this.stateId = stateId;
    }

    /**
     * A constructor with date.
     */
    public Item() {
        this.creationDate = new Date().getTime();
    }

    /**
     * The getter for user's id.
     * @return id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * The setter for user's id.
     * @param userId user's id.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * The getter for the category.
     * @return id of the category.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * The setter for the category.
     * @param categoryId id of the category.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * The getter for the state.
     * @return the state id.
     */
    public int getStateId() {
        return stateId;
    }

    /**
     * The setter for the state.
     * @param stateId id of the state.
     */
    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Item item = (Item) o;
        return creationDate == item.creationDate && categoryId == item.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creationDate, categoryId);
    }

    @Override
    public String toString() {
        return "Item {"
                + "id=" + getId()
                + ", name=" + getName()
                + ", description=" + getDescription()
                + ", user id=" + userId
                + ", category id=" + categoryId
                + ", state id=" + stateId
                + '}';
    }
}
