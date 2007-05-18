package net.chrisrichardson.umangite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;

public class SeleniumLauncher extends DelegatingSelenium {

	protected Log logger = LogFactory.getLog(getClass());

	protected SeleniumServer selServer;

	protected String getBrowserType() {
		return "*iexplore";
	}

	protected String getPort() {
		return "8080";
	}

	protected String getHost() {
		return "localhost";
	}

	public void startSelenium() throws Exception {
		logger.debug("starting selenium server");

		selServer = new SeleniumServer();

		selServer.start();
		logger.debug("starting selenium ");

		selenium = new DefaultSelenium("localhost", selServer.getPort(),
				getBrowserType(), "http://" + getHost() + ":" + getPort() + "/");
		selenium.start();
		logger.debug("selenium started");
	}

	public void stopSelenium() {
		try {
			selenium.stop();
		} catch (Throwable e) {
			logger.error(e);
		}

		selServer.stop();
	}
}
