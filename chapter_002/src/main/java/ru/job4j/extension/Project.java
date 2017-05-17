package ru.job4j.extension;

/**
 * Class Project.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class Project {
    /**
     * name of project.
     */
    private String name;
    /**
     * spent time.
     */
    private int time;
    /**
     * spent money.
     */
    private float money;

    /**
     * Constructor.
     * @param name of project.
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * Geter for name fild.
     * @return name of project.
     */
    public String getName() {
        return name;
    }

    /**
     * Seter for time fild.
     * @param time set time.
     */
    public void setTime(int time) {
        this.time += time;
    }

    /**
     * Calculate money.
     * @param money for calculating.
     */
    public void setMoney(float money) {
        this.money += money;
    }
}
