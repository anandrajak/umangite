package net.chrisrichardson.umangite.pagecomponents;

import net.chrisrichardson.umangite.WebTestSupport;


public abstract class AbstractPage extends WebTestSupport {

	@Override
	protected String[] getConfigLocations() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected String[] getUmangiteConfigLocations() {
    throw new UnsupportedOperationException();
	}


}