package ru.job4j.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Item describes item.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Item {

    /**
     * An identification of an element.
     */
    private String id;

    /**
     * A name of element.
     */
    private String name;

    /**
     * A description of an element.
     */
    private String description;

    /**
     * A date when an element was created.
     */
    private long created;

    /**
     * A list of an item's comments.
     */
    private List<String> comments;

    /**
     * A constant for generation id.
     */
    private static int generateId = 0;

    /**
     * A constructor with parameters for class Item.
     * @param name for a created item.
     * @param description of a created item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = System.currentTimeMillis();
        this.id = String.valueOf(generateId++);
        this.comments = new ArrayList<>();
    }

    /**
     * A getter for id field.
     * @return a value of id field.
     */
    public String getId() {
        return id;
    }

    /**
     * A setter for id field.
     * @param id for item.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A getter for name field.
     * @return a value of id name.
     * */
    public String getName() {
        return name;
    }

    /**
     * A setter for name field.
     * @param name of an item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter for description field.
     * @return a value of description field.
     */
    public String getDescription() {
        return description;
    }

    /**
     * A setter for description field.
     * @param description of an item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * A getter for created field.
     * @return a value of created field.
     */
    public long getCreated() {
        return created;
    }

    /**
     * A getter for comments field.
     * @return an array of comments.
     */
    public List<String> getComments() {
        return comments;
    }

    /**
     * A setter for comments field.
     * @param comments a line of comment passed by.
     */
    public void setComments(String comments) {
        this.comments.add(comments);
    }

    /**
     * An equals for a class Item.
     * @param o an instance to compare.
     * @return result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (created != item.created) {
            return false;
        }
        if (id != null ? !id.equals(item.id) : item.id != null) {
            return false;
        }
        if (name != null ? !name.equals(item.name) : item.name != null) {
            return false;
        }
        if (description != null ? !description.equals(item.description) : item.description != null) {
            return false;
        }
        return comments != null ? comments.equals(item.comments) : item.comments == null;
    }

    /**
     * A hashCode for Item.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (created ^ (created >>> 32));
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
