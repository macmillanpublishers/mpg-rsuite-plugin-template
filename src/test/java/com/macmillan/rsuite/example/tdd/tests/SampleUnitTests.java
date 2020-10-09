package com.macmillan.rsuite.example.tdd.tests;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleUnitTests {

	private final Log logger = LogFactory.getLog(getClass());

	@Before // setup()
	public void before() {
		logger.info("Setting it up!");
	}

	@After // tearDown()
	public void after() {
		logger.info("Running: tearDown");
	}

	@Test
	public void testOne() throws Exception {
		logger.info( "test started...");
		assertTrue(true);
	}
}

