package net.chrisrichardson.umangite;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.http.SocketListener;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.WebApplicationContext;
import org.mortbay.util.InetAddrPort;
import org.springframework.util.Assert;

public class JettyLauncher extends AbstractWebContainerLauncher {

	protected Server server;

	private String webAppDirectory = "src/main/webapp";

	private String srcWebApp;

	public void setWebAppDirectory(String webAppDirectory) {
		this.webAppDirectory = webAppDirectory;
	}

	public String getSrcWebApp() {
		return srcWebApp;
	}

	public void setSrcWebApp(String srcWebApp) {
		this.srcWebApp = srcWebApp;
	}

	public void start() throws Exception {

		prepareWarDirectory();
		server = new Server();
		SocketListener listener = new SocketListener(new InetAddrPort(determineAndRememberActualPort()));
		server.addListener(listener);
		WebApplicationContext context = makeContext();
		logger.info("Deploying with context path: " + contextPath);
		context.setContextPath("/" + getContextPath());
		server.addContext(context);
		server.start();
		logger.info("Web container started on port " + getActualPort());
	}

	private WebApplicationContext makeContext() {
		File webAppDirFile = new File(getWebAppDirectory());

		Assert.isTrue(webAppDirFile.exists(), "Non-existent: "
				+ getWebAppDirectory());
		if (getSrcWebApp() != null)
			return new ScatteredWebApplicationContext(getWebAppDirectory(),
					getSrcWebApp());
		else
			return new WebApplicationContext(getWebAppDirectory());
	}

	public void stop() throws InterruptedException {
		if (server.isStarted())
			server.stop();
	}

	protected void prepareWarDirectory() {
		// Do nothing. subclasses can override
	}

	protected String getWebAppDirectory() {
		return webAppDirectory;
	}
	
	public static void main(String[] args) throws Exception {
		new JettyLauncher().start();
	}
}
