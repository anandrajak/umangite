package net.chrisrichardson.umangite.tests;

import org.testng.annotations.Test;

@Test
public class UmangiteTomcatWithDynamicPortTests extends AbstractUmangiteFunctionalTests {

	@Override
	protected String getContainerType() {
		return "tomcat.dynamic.port";
	}
}
