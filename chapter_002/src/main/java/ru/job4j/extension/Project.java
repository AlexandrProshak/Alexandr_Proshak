package ru.job4j.extension;

/**
 * Class Project describes a simple template of a project.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Project {
    /**
     * A name of project.
     */
    private String name;
    /**
     * A time was spent.
     */
    private int time;
    /**
     * A money was spent.
     */
    private float money;

    /**
     * A constructor.
     * @param name of a project.
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * Geter for name's field.
     * @return name of a project.
     */
    public String getName() {
        return name;
    }

    /**
     * Seter for a time's field.
     * @param time set time.
     */
    public void setTime(int time) {
        this.time += time;
    }

    /**
     * Calculating money was spent for the project.
     * @param money for calculating.
     */
    public void setMoney(float money) {
        this.money += money;
    }
}
