package com.github.kuper3.bookscatalog.util;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;


public class VersionTest {

	private static Logger LOG = Logger.getLogger(VersionTest.class);
	
	@Test
	public void testVersion()
	{
		try {
			LOG.debug("Version from filtered properties :"+ Version.VALUE);
			assertFalse("BooksCatalog-util.properties is not filtered", "${app.version}".equals(Version.VALUE));
		} catch (ExceptionInInitializerError e) {
			LOG.error("BooksCatalog-util.properties could not be read");
			fail("Filtering is buggy under M2Eclipse, try cleaning the project or doing a 'touch' on BooksCatalog-util.properties");
		}
	}
}
