package net.chrisrichardson.umangite.tests;

import org.testng.annotations.Test;

@Test
public class UmangiteJettyWithDynamicPortTests extends AbstractUmangiteFunctionalTests {

	@Override
	protected String getContainerType() {
		return "jetty.dynamic.port";
	}
}
