package com.example.retryFailedTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTestFailure {
	@Test
	public void test() {
		Assert.assertEquals(true, false);
	}

	@Test
	public void testOne() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void testTwo() {
		Assert.assertTrue(false);
	}
}
