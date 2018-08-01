package ru.job4j.task2;

import java.util.Random;

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
     * An array of an item comments.
     */
    private String[] comments;
    /**
     * length of comment's array.
     */
    private int position = 0;

    /**
     * A constant for generation id.
     */
    private static final Random RN = new Random();

    /**
     * A constructor with parameters for class Item.
     * @param name for a created item.
     * @param description of a created item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = System.currentTimeMillis();
        this.id = generateId();
        this.comments = new String[10];
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
    public String[] getComments() {
        return comments;
    }

    /**
     * A setter for comments field.
     * @param comments a line of comment passed by.
     */
    public void setComments(String comments) {
        this.comments[position++] = comments;
    }

    /**
     * A method generateId creates unique id for item.
     * @return id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
