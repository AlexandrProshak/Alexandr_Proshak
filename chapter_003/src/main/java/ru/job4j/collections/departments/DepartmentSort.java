package ru.job4j.collections.departments;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
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
    private Set<String> departments;

    /**
     * DepartmentSort class constructor.
     * @param list of departments to sort.
     */
    public DepartmentSort(Collection<String> list) {
        this.departments = new HashSet<>();
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
        Set<String> result = new TreeSet<>();
        result.addAll(this.departments);
        return result;
    }

    /**
     * Method descendingDepSort()
     * sorts a given list of departments by descending order.
     * @return sorted collection in descending order.
     */
    public Collection<String> descendingDepSort() {
        Set<String> result = new TreeSet<>(descending);
        result.addAll(this.departments);
        return result;
    }

    /**
     * Comparator for an descending order.
     */
    private Comparator<String> descending = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int result = 0;
            String[] st1 = o1.split("\\\\");
            String[] st2 = o2.split("\\\\");

            int departLength1 = st1.length;
            int departLength2 = st2.length;
            int minDepLength = Math.min(departLength1, departLength2);

            result += (departLength1 - departLength2);
            int index = 0;

            while (index < minDepLength) {
                if (!st1[index].equals(st2[index])) {
                    result += st2[index].compareTo(st1[index]) * (1000 / (index + 1));
                    break;
                }
                index++;
            }
            return result;
        }
    };
}

