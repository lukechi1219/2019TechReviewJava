package com.nv.tech.ideavim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author luke
 */
public class DemoTest {

	/**
	jtest
	Tennis.new
	zl.var
	zn
	o
	tennis.score()
	alt enter
	w xa
	ctrl shift enter
	.ae
	ctrl shift r
	 */
	@Test
	public void testLoveAll() {
		Tennis tennis = new Tennis();
		assertEquals("love all", tennis.score());
	}

}
