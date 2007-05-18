package net.chrisrichardson.umangite;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.http.SocketListener;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.WebApplicationContext;
import org.mortbay.util.InetAddrPort;
import org.springframework.util.Assert;

public class JettyLauncher implements WebContainerLauncher {

	private Log logger = LogFactory.getLog(getClass());

	protected Server server;

	private int port = 8080;

	private String contextPath;

	private String webAppDirectory = "src/main/webapp";

	private String srcWebApp;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

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
		SocketListener listener = new SocketListener(new InetAddrPort(port));
		server.addListener(listener);
		WebApplicationContext context = makeContext();
		context.setContextPath("/" + getContextPath());
		server.addContext(context);
		server.start();
		logger.info("Web container started on port " + port);
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

	protected String getContextPath() {
		return contextPath;
	}

	protected void prepareWarDirectory() {
		// Do nothing. subclasses can override
	}

	protected String getWebAppDirectory() {
		return webAppDirectory;
	}
	

}
