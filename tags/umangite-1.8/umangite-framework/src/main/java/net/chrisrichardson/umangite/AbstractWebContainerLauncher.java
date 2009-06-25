package net.chrisrichardson.umangite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractWebContainerLauncher implements
		WebContainerLauncher {

	protected Log logger = LogFactory.getLog(getClass());

	private int port = 8080;
	protected String contextPath = "webapp";
	private int actualPort;

	public AbstractWebContainerLauncher() {
		super();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	protected int determineAndRememberActualPort() {
		actualPort = PortUtil.allocatePortIfRequired(port);
		return actualPort;
	}

	public String getContextPath() {
		return contextPath;
	}

	public int getActualPort() {
		return actualPort;
	}

}