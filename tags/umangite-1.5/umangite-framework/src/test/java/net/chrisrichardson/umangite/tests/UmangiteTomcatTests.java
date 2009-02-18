package net.chrisrichardson.umangite.tests;

import org.testng.annotations.Test;

@Test
public class UmangiteTomcatTests extends AbstractUmangiteFunctionalTests {

	@Override
	protected String getContainerType() {
		return "tomcat";
	}
	
}
