package ru.job4j.collections.departments;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DepartmentSortTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentSortTest {

    /**
     * Department's list.
     */
    private List<String> departmentsList;

    /**
     * Link for an instance of DepartmentSort class.
     */
    private DepartmentSort departmentSort;

    /**
     * Initial date.
     */
    @Before
    public void setUp() {
        this.departmentsList = new ArrayList<>();
        this.departmentsList.add("K1\\SK1\\SSK1");
        this.departmentsList.add("K1\\SK2");
        this.departmentsList.add("K1\\SK1\\SSK2");
        this.departmentsList.add("K2");
        this.departmentsList.add("K2\\SK1\\SSK1");
        this.departmentsList.add("K2\\SK1\\SSK2");
        this.departmentSort = new DepartmentSort(this.departmentsList);
    }

    /**
     * Testing ascending order.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenGiveDepartmentsListThenReturnAscendingSortedCollection() throws Exception {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("K1");
        expectedResult.add("K1\\SK1");
        expectedResult.add("K1\\SK1\\SSK1");
        expectedResult.add("K1\\SK1\\SSK2");
        expectedResult.add("K1\\SK2");
        expectedResult.add("K2");
        expectedResult.add("K2\\SK1");
        expectedResult.add("K2\\SK1\\SSK1");
        expectedResult.add("K2\\SK1\\SSK2");


        Collection<String> result = this.departmentSort.ascendingDepSort();

        assertThat(expectedResult.toString(), is(result.toString()));

    }

    /**
     * Testing descending order.
     * @throws Exception if something went wrong.
     */
    @Test
    public void whenGiveDepartmentsListThenReturnDescendingSortedCollection() throws Exception {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("K2");
        expectedResult.add("K2\\SK1");
        expectedResult.add("K2\\SK1\\SSK2");
        expectedResult.add("K2\\SK1\\SSK1");
        expectedResult.add("K1");
        expectedResult.add("K1\\SK2");
        expectedResult.add("K1\\SK1");
        expectedResult.add("K1\\SK1\\SSK2");
        expectedResult.add("K1\\SK1\\SSK1");

        Collection<String> result = this.departmentSort.descendingDepSort();

        assertThat(expectedResult.toString(), is(result.toString()));
    }
}