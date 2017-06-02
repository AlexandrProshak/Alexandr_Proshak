package ru.job4j.polymorphism;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class StubInputTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class StubInputTest {
    /**
     * A field for an instance of class Tracker.
     */
    private Tracker tracker;

    /**
     * Set up initialisation date of project.
     *
     * @throws Exception if something was wrong.
     */
    @Before
    public void initialize() throws Exception {
        tracker = new Tracker();
    }

    /**
     * Testing an item "Add new Item" to the tracker.
     *
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws Exception {
        //create a StubInput with a needed action.
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        //create StartUi and call init().
        new StartUi(this.tracker, input).init();
        //check that 0 element in array has name, was entered through an emulation.
        assertThat(this.tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Testing an item "Show all items" into the tracker.
     *
     * @throws Exception if something goes wrong.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenUserAddFiveItemsThenTrackerShowsFiveItemsWithoutNull() throws Exception {
        //create a StubInput with a needed action.
        Input input = new StubInput(new String[]{
                "0", "test name 1", "desc 1",
                "0", "test name 2", "desc 2",
                "0", "test name 3", "desc 3",
                "0", "test name 4", "desc 4",
                "0", "test name 5", "desc 5",
                "1", "6"});
        new StartUi(this.tracker, input).init();
        assertNotEquals(tracker.findAll(), null);
        assertThat(this.tracker.findAll()[0].getName(), is("test name 1"));
        assertThat(this.tracker.findAll()[1].getName(), is("test name 2"));
        assertThat(this.tracker.findAll()[2].getName(), is("test name 3"));
        assertThat(this.tracker.findAll()[3].getName(), is("test name 4"));
        assertThat(this.tracker.findAll()[4].getName(), is("test name 5"));
        assertNotEquals(this.tracker.findAll()[5].getName(), is("test name 6"));
    }

    /**
     * Testing an item "Edit item" into the tracker.
     *
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenUserEditItemThenTrackerHasEditedItem() throws Exception {
        this.tracker.add(new Item("test name 1", "desc 1"));
        this.tracker.add(new Item("test name 2", "desc 2"));
        String id = this.tracker.findAll()[0].getId();
        Input input = new StubInput(new String[]{
                "2", id,
                "new test name", "new desc", "a new comment was added",
                "6"});
        new StartUi(this.tracker, input).init();
        assertThat(this.tracker.findById(id).getName(), is("new test name"));
        assertThat(this.tracker.findById(id).getDescription(), is("new desc"));
        assertThat(this.tracker.findById(id).getComments()[0], is("a new comment was added"));
        assertTrue(this.tracker.findByName("test name 1").length == 0);
    }

    /**
     * Testing an item "Delete item" from the tracker.
     *
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNotThatItem() throws Exception {
        this.tracker.add(new Item("test name 1", "desc 1"));
        this.tracker.add(new Item("test name 2", "desc 2"));
        String id = this.tracker.findAll()[0].getId();
        Input input = new StubInput(new String[]{
                "3", id, "6"});
        new StartUi(this.tracker, input).init();
        assertNull(this.tracker.findById(id));
        assertEquals(this.tracker.findByName("test name 1").length, 0);
    }

    /**
     * Testing an item "Find item by Id" into the tracker.
     *
     * @throws Exception if something goes wrong.
     */
    @Test
    public void whenUserSearchByIdThenTrackerShowThatItem() throws Exception {
        this.tracker.add(new Item("test name 1", "desc 1"));
        this.tracker.add(new Item("test name 2", "desc 2"));
        String id = this.tracker.findAll()[0].getId();
        Input input = new StubInput(new String[]{
                "4", id, "6"});
        new StartUi(this.tracker, input).init();
        assertEquals(this.tracker.findById(id).getId(), id);
        assertEquals(this.tracker.findById(id).getName(), "test name 1");
    }

    /**
     * Testing an item "Find items by name" into the tracker.
     *
     * @throws Exception if something goes wrong.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenUserSearchByNameThenTrackerShowThatItem() throws Exception {
        Input input = new StubInput(new String[]{
                "0", "test name 1", "desc 1",
                "0", "test name 1", "desc 2",
                "0", "test name 3", "desc 3",
                "5", "test name 1", "6"});
        new StartUi(this.tracker, input).init();
        assertEquals(this.tracker.findByName("test name 1")[0].getDescription(), "desc 1");
        assertEquals(this.tracker.findByName("test name 1")[1].getDescription(), "desc 2");
        assertEquals(this.tracker.findByName("test name 1")[2].getDescription(), "desc 3");
    }
}