package ru.job4j.task4;


import java.util.Objects;

/**
 * Enum describes persons gender.
 */
enum Sex {
    /**
     * Gender for man.
     */
    Male,

    /**
     * Gender for woman.
     */
    Female
}

/**
 * The Person class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Person {

    /**
     * First name.
     */
    private String firstName;

    /**
     * Second name.
     */
    private String secondName;

    /**
     * Sex.
     */
    private Sex sex;

    /**
     * Description.
     */
    private String description;

    /**
     * Getter.
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter.
     * @param firstName parameter.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter.
     * @return second name.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Setter.
     * @param secondName parameter.
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Getter.
     * @return sex.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Setter.
     * @param sex parameter.
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Getter.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter.
     * @param description parameter.
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
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName)
                && Objects.equals(secondName, person.secondName)
                && sex == person.sex
                && Objects.equals(description, person.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, sex, description);
    }

    /**
     * The method is overridden according to JSON format.
     * @return string.
     */
    @Override
    public String toString() {
        return String.format(
         "[person firstName=%s, secondName=%s, sex=%s, description=%s]",
         this.firstName, this.secondName, this.sex, this.description);
    }
}