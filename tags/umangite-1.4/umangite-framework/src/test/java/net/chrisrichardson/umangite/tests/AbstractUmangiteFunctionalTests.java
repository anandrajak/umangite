package net.chrisrichardson.umangite.tests;

import org.testng.annotations.Test;

import net.chrisrichardson.umangite.AbstractSeleniumTest;

public abstract class AbstractUmangiteFunctionalTests extends AbstractSeleniumTest {

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "appCtxForUmangite/common/*.xml", "appCtxForUmangite/" + getContainerType()
				+ "/**/*.xml", };
	}
	
	@Test
	public void test() {
		open("/testwebapp/index.html");
		assertTextPresent("Hello There");
	}


}
