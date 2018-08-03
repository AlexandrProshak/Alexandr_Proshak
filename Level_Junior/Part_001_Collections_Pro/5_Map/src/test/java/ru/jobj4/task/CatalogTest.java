package ru.jobj4.task;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

/**
 * CatalogTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CatalogTest {

    /**
     * A field for the instance of Catalog class.
     */
    private Catalog<Integer, String> catalog;

    /**
     * Setups initial date.
     */
    @Before
    public void setUp() {
        this.catalog = new Catalog<Integer, String>();
    }

    /**
     * Tests method insert().
     */
    @Test
    public void whenInsertPairToCatalogThanReturnsTrue() {
        assertTrue(this.catalog.insert(1, "one"));
    }

    /**
     * Tests method insert() in case try to insert an two elements with the same key.
     */
    @Test
    public void whenInsertPairWithDuplicatedKeyThanReturnsFalse() {
        this.catalog.insert(1, "one");
        assertFalse(this.catalog.insert(1, "two"));
    }

    /**
     * Tests method get().
     * @throws InvalidKeyException if key is wrong.
     */
    @Test
    public void whenGetElementByKeyFromCatalogThanReturnsValue() throws InvalidKeyException {
        this.catalog.insert(1, "one");
        this.catalog.insert(2, "one");
        this.catalog.insert(3, "one");
        this.catalog.insert(23, "bingo");
        this.catalog.insert(4, "four");
        assertThat(this.catalog.get(23), is("bingo"));
    }

    /**
     * Tests method get() in case invalid key.
     * @throws InvalidKeyException if key is wrong.
     */
    @Test(expected = InvalidKeyException.class)
    public void whenGetElementByUnPresentKeyFromCatalogThanInvalidKeyException() throws InvalidKeyException {
        this.catalog.insert(1, "one");
        this.catalog.insert(23, "bingo");
        this.catalog.get(2);
    }

    /**
     * Tests iterator().
     */
    @Test
    public void whenHasNextAndNextThanReturnsValue() {
        this.catalog.insert(1, "one");
        this.catalog.insert(2, "two");
        this.catalog.insert(2, "two");
        this.catalog.insert(3, "three");
        this.catalog.insert(4, "three");
        this.catalog.insert(3, "three");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("one");
        expectedResult.add("two");
        expectedResult.add("three");
        expectedResult.add("three");

        List<String> result = new ArrayList<>();
        Iterator<Catalog.Node> it = (Iterator<Catalog.Node>) this.catalog.iterator();

        while (it.hasNext()) {
            result.add((String) it.next().getValue());
        }

        assertTrue(expectedResult.containsAll(result));
    }

    /**
     * Tests catalog with initial capacity and load factor.
     */
    @Test
    public void whenPutCapacityAndLoadFactorThanCatalogWorksCorrect() {
        Catalog<String, String> cat = new Catalog<>(6, 0.5f);
        cat.insert("one", "one");
        cat.insert("two", "one");
        cat.insert("two", "one");
        cat.insert("three", "one");
        cat.insert("four", "one");
        cat.insert("four", "one");
        cat.insert("five", "one");
        cat.insert("five", "one");
        cat.insert("six", "one");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("one");
        expectedResult.add("one");
        expectedResult.add("one");
        expectedResult.add("one");
        expectedResult.add("one");
        expectedResult.add("one");

        List<String> result = new ArrayList<>();
        Iterator<Catalog.Node> it = (Iterator<Catalog.Node>) cat.iterator();

        while (it.hasNext()) {
            result.add((String) it.next().getValue());
        }

        assertTrue(expectedResult.containsAll(result));
    }

}