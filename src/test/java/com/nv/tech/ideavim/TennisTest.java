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
 * .ae
 * zn
 * w
 * alt enter
 * w
 * zb
 * ctrl + tab
 * zra -> refactor + run (test)
 * <p>
 * zrf -> introduce field
 * alt + i
 * VM
 * zrp -> introduce parameter
 * <p>
 * zri -> inline
 * <p>
 * zdm
 * zuc
 * <p>
 * ?test
 * zb
 */
public class TennisTest {

	private final Tennis tennis = new Tennis();

	@Test
	public void loveAll() {
		scoreShouldBe("love all");
	}

	@Test
	public void fifteenLove() {
		tennis.firstPlayerScore();
		scoreShouldBe("fifteen love");
	}

	@Test
	public void thirtyLovje() {
		tennis.firstPlayerScore();
		tennis.firstPlayerScore();
		scoreShouldBe("thirty love");
	}

	private void scoreShouldBe(String expected) {
		assertEquals(expected, tennis.score());
	}
}