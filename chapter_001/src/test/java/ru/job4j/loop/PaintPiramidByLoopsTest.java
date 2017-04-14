package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Tests for loop tasks).
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class PaintPiramidByLoopsTest {
	/**
	* Test for painting piramid.
	*/
	@Test
	public void whenH1ThenW1() {
		PaintPiramidByLoops paint = new PaintPiramidByLoops();
		String result = paint.piramid(1);
		assertThat(result, is(String.format("^%s", "\n")));
	}
	/**
	* Test for painting piramid.
	*/
	@Test
	public void whenH2ThenW3() {
		PaintPiramidByLoops paint = new PaintPiramidByLoops();
		String result = paint.piramid(2);
		assertThat(result, is(String.format(" ^%s^^^%s", "\n", "\n")));
	}
		/**
	* Test for painting piramid.
	*/
	@Test
	public void whenH3ThenW5() {
		PaintPiramidByLoops paint = new PaintPiramidByLoops();
		String result = paint.piramid(3);
		assertThat(result, is(String.format("  ^%s ^^^%s^^^^^%s", "\n", "\n", "\n")));
	}
}
