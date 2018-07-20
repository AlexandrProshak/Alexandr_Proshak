package ru.job4j.mvc.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The class City.
 */
@JsonAutoDetect
public class City {

    /**
     * The city's id.
     */
    @JsonIgnore
    private int id;

    /**
     * The city's name.
     */
    @JsonProperty
    private String name;

    /**
     * The country's id.
     */
    @JsonProperty
    private int countryId;

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
     * @return id.
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

    /**
     * The getter.
     * @return id.
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * The setter.
     * @param countryId parameter.
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return id == city.id
                && countryId == city.countryId
                && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, countryId);
    }
}
