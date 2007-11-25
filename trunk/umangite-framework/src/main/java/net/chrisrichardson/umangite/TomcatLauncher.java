package net.chrisrichardson.umangite;

import java.io.File;
import java.net.URL;

import org.codehaus.cargo.container.deployable.WAR;
import org.codehaus.cargo.container.installer.ZipURLInstaller;
import org.codehaus.cargo.container.property.GeneralPropertySet;
import org.codehaus.cargo.container.property.ServletPropertySet;
import org.codehaus.cargo.container.tomcat.Tomcat5xInstalledLocalContainer;
import org.codehaus.cargo.container.tomcat.Tomcat5xStandaloneLocalConfiguration;
import org.codehaus.cargo.util.log.SimpleLogger;

public class TomcatLauncher extends AbstractWebContainerLauncher implements WebContainerLauncher {


	private Tomcat5xInstalledLocalContainer container;

	private String warFile;

  private String tomcatDownloadUrl = "http://archive.apache.org/dist/tomcat/tomcat-5/v5.5.25/bin/apache-tomcat-5.5.25.zip";

	public void setWarFile(String warFile) {
		this.warFile = warFile;
	}

	public void setTomcatDownloadUrl(String tomcatDownloadUrl) {
    this.tomcatDownloadUrl = tomcatDownloadUrl;
  }
	
	public void start() throws Exception {
		logger.debug("installing tomcat");

		File tempDir = getTempDir();

		ZipURLInstaller installer = new ZipURLInstaller(
				new URL(
						tomcatDownloadUrl),
				new File(tempDir, "tomcat-install"));
		installer.install();
		File home = installer.getHome();

		logger.debug("starting tomcat");

		Tomcat5xStandaloneLocalConfiguration config = new Tomcat5xStandaloneLocalConfiguration(
				new File(tempDir, "tomcat-deploy"));
		config.setProperty(ServletPropertySet.PORT, Integer.toString(determineAndRememberActualPort()));
		config.setLogger(new SimpleLogger());
		config.setProperty(GeneralPropertySet.LOGGING, "high");

		WAR war = new WAR(locateWAR(warFile));
		logger.info("Deploying with context path: " + getContextPath());
		war.setContext(getContextPath());

		config.addDeployable(war);

		container = new Tomcat5xInstalledLocalContainer(config);
		container.setHome(home);
		container.setOutput(new File("target/tomcat.log"));
		container.setTimeout(15 * 1000);

		container.start();
		logger.info("Web container started on port " + getActualPort());
	}

	public void stop() throws Exception {
		container.stop();
	}

	private File getTempDir() {
		// Use one of this directories if possible to avoid issues with RMI and paths with spaces
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
