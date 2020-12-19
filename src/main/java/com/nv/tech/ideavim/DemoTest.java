package com.nv.tech.ideavim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author luke
 * <p>
 * jtest
 * Tennis.new
 * zl.var
 * zn
 * o
 * tennis.score()
 * alt enter
 * w xa
 * ctrl shift enter
 * .ae
 * zra -> refactor + run (test)
 *
 * zrf -> introduce field
 * zrp -> introduce parameter
 * zri -> inline
 */
public class DemoTest {

	private final Tennis tennis = new Tennis();

	@Test
	public void testLoveAll() {
		scoreShouldBe("love all");
	}

	@Test
	public void testFifteenLove() {
		tennis.firstPlayerScore();
		scoreShouldBe("fifteen love");
	}

	private void scoreShouldBe(String expected) {
		assertEquals(expected, tennis.score());
	}

}
