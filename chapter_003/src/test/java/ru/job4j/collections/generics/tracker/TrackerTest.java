package ru.job4j.collections.generics.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest describes tests for the class Tracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
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
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        List<Item> expected = new ArrayList<>();
        expected.add(this.itemA);
        expected.add(this.itemB);
        expected.add(this.itemC);
        List<Item> result = this.tracker.findAll();
        assertThat(expected, is(result));
    }

    /**
     * Testing a method update.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenUpdateItemThanReturnUpdatedOne() throws Exception {
        Item itemCheck = new Item("check", "checking item");
        String id = this.itemB.getId();
        itemCheck.setId(id);
        this.tracker.update(itemCheck);
        Item result = this.tracker.findById(id);
        assertThat(itemCheck, is(result));
    }

    /**
     * Testing a method delete.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenDeleteItemFromTrackerThanFindByIdReturnNull() throws Exception {
        String id = this.itemA.getId();
        this.tracker.delete(this.itemA);
        assertNull(this.tracker.findById(id));
    }

    /**
     * Testing a method findAll.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenFindAllThanReturnArrayWithoutNull() throws Exception {
        assertNotNull(this.tracker.findAll());
    }

    /**
     * Testing a method findByName.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenTrackerHasTwoItemsWithSameNameThanReturnBoth() throws Exception {
        List<Item> expected = new ArrayList<>();
        expected.add(this.itemA);
        expected.add(this.itemB);
        List<Item> result = this.tracker.findByName("first");
        assertThat(expected, is(result));
    }

    /**
     * Testing a method findById.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenTrackerHasItemWithSpecifiedIdThanSpecifiedDescriptionMustMach() throws Exception {
        assertEquals("first description",
                this.tracker.findById(this.itemA.getId()).getDescription());
    }

    /**
     * Testing a method findById when specified id is absent.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenTrackerHasNotItemWithSpecifiedIdThanReturnNull() throws Exception {
        assertNull(this.tracker.findById(this.itemA.getId() + "!"));
    }

    /**
     * Testing a method findById when specified id is absent.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenPassNullLikeArgumentForThanReturnNull() throws Exception {
        assertNull(this.tracker.findById(null));
    }
}