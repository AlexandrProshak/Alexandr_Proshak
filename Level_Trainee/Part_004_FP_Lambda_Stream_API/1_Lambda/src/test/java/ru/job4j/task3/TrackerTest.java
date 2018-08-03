package ru.job4j.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Class TrackerTest describes tests for the class Tracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class TrackerTest {

    /**
     * A current tracker Test.
     */
    private Tracker tracker;

    /**
     * The first item for tests.
     */
    private Item itemA;

    /**
     * The second item for tests.
     */
    private Item itemB;

    /**
     * The third item for tests.
     */
    private Item itemC;

    /**
     * Set up initialisation date of project.
     */
    @Before
    public void setUp() {
        this.tracker = new Tracker();
        this.itemA = new Item("first", "first description");
        this.itemB = new Item("first", "second description");
        this.itemC = new Item("third", "third description");
        this.tracker.add(this.itemA);
        this.tracker.add(this.itemB);
        this.tracker.add(this.itemC);
    }

    /**
     * Testing a method add new item to the tracker.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        List<Item> expected = new ArrayList<>();
        expected.add(this.itemA);
        expected.add(this.itemB);
        expected.add(this.itemC);
        List<Item> result = this.tracker.findAll();
        assertThat(expected, is(result));
    }

    /**
     * Testing a method update.
     */
    @Test
    public void whenUpdateItemThanReturnUpdatedOne() {
        Item itemCheck = new Item("check", "checking item");
        String id = this.itemB.getId();
        itemCheck.setId(id);
        this.tracker.update(itemCheck);
        Item result = this.tracker.findById(id);
        assertThat(itemCheck, is(result));
    }

    /**
     * Testing a method delete.
     */
    @Test
    public void whenDeleteItemFromTrackerThanFindByIdReturnNull() {
        String id = this.itemA.getId();
        this.tracker.delete(this.itemA);
        assertNull(this.tracker.findById(id));
    }

    /**
     * Testing a method findAll.
     */
    @Test
    public void whenFindAllThanReturnArrayWithoutNull() {
        assertNotNull(this.tracker.findAll());
    }

    /**
     * Testing a method findByName.
     */
    @Test
    public void whenTrackerHasTwoItemsWithSameNameThanReturnBoth() {
        List<Item> expected = new ArrayList<>();
        expected.add(this.itemA);
        expected.add(this.itemB);
        List<Item> result = this.tracker.findByName("first");
        assertThat(expected, is(result));
    }

    /**
     * Testing a method findById.
     */
    @Test
    public void whenTrackerHasItemWithSpecifiedIdThanSpecifiedDescriptionMustMach() {
        assertEquals("first description",
                this.tracker.findById(this.itemA.getId()).getDescription());
    }

    /**
     * Testing a method findById when specified id is absent.
     */
    @Test
    public void whenTrackerHasNotItemWithSpecifiedIdThanReturnNull() {
        assertNull(this.tracker.findById(this.itemA.getId() + "!"));
    }

    /**
     * Testing a method findById when specified id is absent.
     */
    @Test
    public void whenPassNullLikeArgumentForThanReturnNull() {
        assertNull(this.tracker.findById(null));
    }
}