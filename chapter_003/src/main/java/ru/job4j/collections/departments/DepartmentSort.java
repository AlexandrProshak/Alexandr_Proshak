package ru.job4j.collections.departments;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;

/**
 * Class DepartmentSort.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentSort {

    /**
     * A set of unique departments name.
     */
    private TreeSet<String> departments;

    /**
     * DepartmentSort class constructor.
     * @param list of departments to sort.
     */
    public DepartmentSort(Collection<String> list) {
        this.departments = new TreeSet<>();
        for (String string: list) {
            addDepartments(string);
        }
    }

    /**
     * Method addDepartments() adds unique department's name to the list of departments,
     * and creates a hierarchy structure.
     * @param string a department's name.
     */
    private void addDepartments(String string) {
        this.departments.add(string);
        if (string.lastIndexOf('\\') != -1) {
            addDepartments(new String(string.substring(0, string.lastIndexOf('\\'))));
        }
    }

    /**
     * Method ascendingDepSort()
     * sorts a given list of departments by ascending order.
     * @return sorted collection in ascending order.
     */
    public Collection<String> ascendingDepSort() {
        return this.departments;
    }

    /**
     * Method descendingDepSort()
     * sorts a given list of departments by descending order.
     * @return sorted collection in descending order.
     */
    public Collection<String> descendingDepSort() {
        ArrayList<String> list = new ArrayList<>(this.departments);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                if (o1.compareTo(o2) == 1) {
                    result = -o1.length() - o2.length();
                }
                return result;
            }
        });
        return list;
    }
}

