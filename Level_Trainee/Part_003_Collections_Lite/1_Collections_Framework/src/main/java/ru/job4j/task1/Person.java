package ru.job4j.task1;

/**
 * Person.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Person {

    /**
     * Person's name.
     */
    private String name;

    /**
     * Person's surname.
     */
    private String surname;

    /**
     * Person's phone.
     */
    private String phone;

    /**
     * Person's address.
     */
    private String address;

    /**
     * The constructor.
     * @param name parameter.
     * @param surname parameter.
     * @param phone parameter.
     * @param address parameter.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * The getter.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * The getter.
     * @return surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * The getter.
     * @return phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * The getter.
     * @return address.
     */
    public String getAddress() {
        return address;
    }
}

