package net.chrisrichardson.umangite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class LaunchOncePerClassWebTest extends WebTestSupport {

	@BeforeClass
	@Override
	protected void startSeleniumAndWebApplication() throws Exception {
		super.startSeleniumAndWebApplication();
	}

	@AfterClass
	@Override
	public void stopSeleniumAndWebApplication() {
		super.stopSeleniumAndWebApplication();
	}


}
