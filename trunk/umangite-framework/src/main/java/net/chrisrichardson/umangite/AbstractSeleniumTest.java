package net.chrisrichardson.umangite;


public abstract class AbstractSeleniumTest extends LaunchOncePerClassWebTest {

	@Override
	protected final String[] getUmangiteConfigLocations() {
		return getConfigLocations();
	}

}