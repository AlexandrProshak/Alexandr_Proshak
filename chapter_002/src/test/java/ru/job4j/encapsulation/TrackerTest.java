package ru.job4j.encapsulation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertArrayEquals;

/**
 * Class TrackerTest describes tests for the class Tracker.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {

    /**
     * A current tracker test.
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
        assertArrayEquals(new Item[]{this.itemA, this.itemB, this.itemC},
                this.tracker.findAll());
    }

    /**
     * Testing a method update.
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenUpdateItemThanReturnUpdateedOne() throws Exception {
        String id = this.itemB.getId();
        this.itemB.setName("second");
        this.tracker.update(this.itemB);
        assertEquals("second", this.tracker.findById(id).getName());
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
        assertEquals(2, tracker.findByName("first").length);
        for (Item t : tracker.findByName("first")) {
            assertEquals(t.getName(), "first");
        }
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