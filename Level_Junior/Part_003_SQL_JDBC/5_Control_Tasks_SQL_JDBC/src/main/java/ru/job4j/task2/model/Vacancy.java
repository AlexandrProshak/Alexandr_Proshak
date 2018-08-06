package ru.job4j.task2.model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * The class Vacancy describes a subject of vacancy.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Vacancy {

    /**
     * The vacancy id.
     */
    private int id;

    /**
     * The vacancy short description.
     */
    private String description;

    /**
     * The vacancy date.
     */
    private Timestamp date;

    /**
     * The vacancy link to the whole description.
     */
    private String link;

    /**
     * The constructor with the parameters.
     * @param id of vacancy.
     * @param description vacancy.
     * @param date vacancy.
     * @param link vacancy.
     */
    public Vacancy(int id, String description, Timestamp date, String link) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.link = link;
    }

    /**
     * The constructor without parameters.
     */
    public Vacancy() {
    }

    /**
     * The getter.
     * @return parameter.
     */
    public int getId() {
        return id;
    }

    /**
     * The setter.
     * @param id parameter.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter.
     * @return parameter.
     */
    public String getDescription() {
        return description;
    }

    /**
     * The setter.
     * @param description parameter.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The getter.
     * @return parameter.
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * The setter.
     * @param date parameter.
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * The getter.
     * @return parameter.
     */
    public String getLink() {
        return link;
    }

    /**
     * The setter.
     * @param link parameter.
     */
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
