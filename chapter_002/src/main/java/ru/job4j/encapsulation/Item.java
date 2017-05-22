package ru.job4j.encapsulation;

/**
 * Class Item describes item.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
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

    private static int counter = 0;

    public Item(String name, String description, String[] comments) {
        this.id = "id: " + String.valueOf(counter++);
        this.name = name;
        this.description = description;
        this.created = System.currentTimeMillis();
        this.comments = comments;
    }

    /**
     * A getter for id field.
     * @return a value of id field.
     */
    public String getId() {
        return id;
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
     * @param comments an array of comments passed by.
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
