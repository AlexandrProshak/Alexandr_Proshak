package ru.job4j.mvc.model.entity;

import java.util.Objects;

/**
 * The class Country.
 */
public class Country {

    /**
     * The country id.
     */
    private int id;

    /**
     * The country name.
     */
    private String name;

    /**
     * The getter.
     * @return id.
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
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * The setter.
     * @param name parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        return id == country.id
                && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
