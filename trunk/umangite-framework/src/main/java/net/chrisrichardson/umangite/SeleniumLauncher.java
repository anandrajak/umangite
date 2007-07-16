package net.chrisrichardson.umangite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;

public class SeleniumLauncher extends DelegatingSelenium {

	protected Log logger = LogFactory.getLog(getClass());

	protected SeleniumServer selServer;

	private String browserType = "*firefox";
	private int port = 8080;

	private static int seleniumServerPort = -1;
	
	protected String getBrowserType() {
		return browserType;
	}
	
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	protected int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	protected String getHost() {
		return "localhost";
	}

	public void startSelenium(int containerPort) throws Exception {
		logger.debug("starting selenium server");

		allocateSeleniumServerPort();
		
		selServer = new SeleniumServer(seleniumServerPort);
		selServer.start();
		logger.debug("Started selenium server on port: " + seleniumServerPort);
		
		logger.debug("starting selenium ");
		String url = "http://" + getHost() + ":" + containerPort + "/";
		logger.debug("Opening url: " + url);
		selenium = new DefaultSelenium("localhost", seleniumServerPort,
				getBrowserType(), url);
		selenium.start();
		logger.debug("selenium started");
	}

	private void allocateSeleniumServerPort() {
		// Do this once/statically because SeleniumServer appears to reuse the same profile
		seleniumServerPort = PortUtil.allocatePortIfRequired(seleniumServerPort);
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
