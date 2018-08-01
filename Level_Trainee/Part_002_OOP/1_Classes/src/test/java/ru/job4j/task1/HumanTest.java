package ru.job4j.task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class HumanTest.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class HumanTest {

    /**
     * Test for get name.
     */
    @Test
    public void whenHumanExistReturnName() {
        Human human = new Human("Tom");
        String getName = human.getName();
        String result = "Tom";
        assertThat(result, is(getName));
    }

}
