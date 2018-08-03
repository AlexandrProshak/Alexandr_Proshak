package ru.job4j.task2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Class AbstractStoreTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class AbstractStoreTest {

    /**
     * The linc for the instance of the UserSore class.
     */
    private Store<User> userStore;

    /**
     * The linc for the instance of the RoleStore class.
     */
    private Store<Role> roleStore;

    /**
     * The linc for the first instance of the User class.
     */
    private User user1;

    /**
     * The linc for the second instance of the User class.
     */
    private User user2;

    /**
     * The linc for the instance of the descendant of the User class.
     */
    private Base user3;

    /**
     * The linc for the first instance of the Role class.
     */
    private Role role1;

    /**
     * The linc for the second instance of the Role class.
     */
    private Role role2;

    /**
     * The linc for the instance of the descendant of the Base class.
     */
    private Base role3;

    /**
     * Sets start date.
     * @throws Exception while something went wrong.
     */
    @Before
    public void setUp() throws Exception {
        this.userStore = new UserStore(5);
        this.roleStore = new RoleStore(5);
        this.user1 = new User("one");
        this.user2 = new User("two");
        this.user3 = new User("three");
        this.role1 = new Role("1");
        this.role2 = new Role("2");
        this.role3 = new Role("3");
    }

    /**
     * Tests method add() with the class User.
     * @throws Exception while something went wrong.
     */
    @Test
    public void whenAddThanReturnTrue() throws Exception {
        this.userStore.add(this.user1);
        this.userStore.add(this.user2);
        assertTrue(this.userStore.add((User) this.user3));
    }

    /**
     * Tests method update() with the class Role.
     * @throws Exception while something went wrong.
     */
    @Test
    public void whenUpdateThanReturnTrue() throws Exception {
        this.roleStore.add(this.role1);
        this.roleStore.add(this.role2);
        assertTrue(this.roleStore.update(this.role1, (Role) this.role3));
    }

    /**
     * Tests method delete() with the class User.
     * @throws Exception while something went wrong.
     */
    @Test
    public void whenDeleteCorrectlyThanReturnTrue() throws Exception {
        this.userStore.add(this.user1);
        this.userStore.add(this.user2);
        this.userStore.add((User) this.user3);
        assertTrue(this.userStore.delete((User) this.user3));
    }
}