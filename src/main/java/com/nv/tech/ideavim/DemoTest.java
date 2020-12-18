package com.nv.tech.ideavim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author luke
 */
public class DemoTest {

	/*
	jtest
	Tennis.new
	zl.var
	o
	tennis.score()
	alt enter
	v w vw
	xa
	.ae
	 */

	@Test
	public void testLoveAll() {
		Tennis tennis = new Tennis();
		assertEquals("love all", tennis.score());
	}
}
