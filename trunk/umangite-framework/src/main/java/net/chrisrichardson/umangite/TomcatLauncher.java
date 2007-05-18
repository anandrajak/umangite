package net.chrisrichardson.umangite;

import java.io.File;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.cargo.container.deployable.WAR;
import org.codehaus.cargo.container.installer.ZipURLInstaller;
import org.codehaus.cargo.container.property.GeneralPropertySet;
import org.codehaus.cargo.container.property.ServletPropertySet;
import org.codehaus.cargo.container.tomcat.Tomcat5xInstalledLocalContainer;
import org.codehaus.cargo.container.tomcat.Tomcat5xStandaloneLocalConfiguration;
import org.codehaus.cargo.util.log.SimpleLogger;

public class TomcatLauncher implements WebContainerLauncher {

	private Log logger = LogFactory.getLog(getClass());

	private Tomcat5xInstalledLocalContainer container;

	private String contextPath;

	private String warFile;

	
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	
	public void setWarFile(String warFile) {
		this.warFile = warFile;
	}


	public void start() throws Exception {
		logger.debug("installing tomcat");

		File tempDir = getTempDir();

		ZipURLInstaller installer = new ZipURLInstaller(
				new URL(
						"http://apache.tradebit.com/pub/tomcat/tomcat-5/v5.0.28/bin/jakarta-tomcat-5.0.28.zip"),
				new File(tempDir, "tomcat-install"));
		installer.install();
		File home = installer.getHome();

		logger.debug("starting tomcat");

		Tomcat5xStandaloneLocalConfiguration config = new Tomcat5xStandaloneLocalConfiguration(
				new File(tempDir, "tomcat-deploy"));
		config.setProperty(ServletPropertySet.PORT, Integer.toString(8080));
		config.setLogger(new SimpleLogger());
		config.setProperty(GeneralPropertySet.LOGGING, "high");

		WAR war = new WAR(locateWAR(warFile));
		war.setContext(contextPath);

		config.addDeployable(war);

		container = new Tomcat5xInstalledLocalContainer(config);
		container.setHome(home);
		container.setOutput(new File("target/tomcat.log"));
		container.setTimeout(15 * 1000);

		container.start();
	}

	public void stop() throws Exception {
		container.stop();
	}

	private File getTempDir() {
		String[] dirs = { "i:\\tmp", "c:\\tmp" };
		for (int i = 0; i < dirs.length; i++) {
			String d = dirs[i];
			File dir = new File(d);
			if (dir.exists())
				return dir;
		}
		return new File(System.getProperty("java.io.tmpdir"));
	}

	private String locateWAR(String path) throws Exception {
		if (new File(path).exists())
			return path;
		path = "../" + path;
		if (new File(path).exists())
			return path;
		throw new Exception("Cannot find path: " + path);
	}


}
