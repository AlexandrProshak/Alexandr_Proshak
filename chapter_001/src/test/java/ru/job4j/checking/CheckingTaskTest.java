package ru.job4j.checking;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for verification of the equivalence of two strings.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class CheckingTaskTest {
	/**
	* Test for equivalence.
	*/
    @Test
    public void whenOriginStringEqualsSubStringThenTrue() {
        CheckingTask controll = new CheckingTask();
        boolean result = controll.contains("papa i mama", "mama");
        boolean expectResult = true;
        assertThat(result, is(expectResult));
    }
    /**
	* Test for Non-equivalence.
	*/
    @Test
    public void whenOriginStringNonEqualsSubStringThenFalse() {
        CheckingTask controll = new CheckingTask();
        boolean result = controll.contains("mama", "papa");
        boolean expectResult = false;
        assertThat(result, is(expectResult));
    }
}