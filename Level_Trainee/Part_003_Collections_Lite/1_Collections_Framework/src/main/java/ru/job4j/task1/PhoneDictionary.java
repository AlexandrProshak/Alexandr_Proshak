package ru.job4j.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PhoneDictionary.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class PhoneDictionary {

    /**
     * The dictionary.
     */
    private List<Person> persons = new ArrayList<>();

    /**
     * The method adds new person to the dictionary.
     * @param person to be added.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * The method returns list of persons which contains key in any field.
     * @param key to search.
     * @return result list.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();
            String name = nextPerson.getName();
            String surname = nextPerson.getSurname();
            String address = nextPerson.getAddress();
            String phone = nextPerson.getPhone();
            if (name.contains(key)
                    || surname.contains(key)
                    || address.contains(key)
                    || phone.contains(key)) {
                result.add(nextPerson);
            }
        }
        return result;
    }
}
