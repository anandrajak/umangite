package net.chrisrichardson.umangite;

import java.io.IOException;

import org.mortbay.jetty.servlet.WebApplicationContext;
import org.mortbay.util.Resource;

public class ScatteredWebApplicationContext extends WebApplicationContext {

	private String srcWebApp;
	private Resource srcWebAppResource;

	public ScatteredWebApplicationContext(String name, String srcWebApp) {
		super(name);
		this.srcWebApp = srcWebApp;
	}
	

	public Resource getResource(String resourceName) throws IOException {
		if ("/WEB-INF/web.xml".equals(resourceName))
			return super.getResource(resourceName);
		if (srcWebAppResource == null) 
			srcWebAppResource = Resource.newResource(srcWebApp);
		Resource r = srcWebAppResource.addPath(resourceName);
		if (r.exists()) {
			return r;
		}
		return super.getResource(resourceName);
	}
	

}
