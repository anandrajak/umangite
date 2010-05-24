package net.chrisrichardson.umangite;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextContainer {

	public Map<String[], ApplicationContext> applicationContexts = new HashMap<String[], ApplicationContext>();

	public ApplicationContext getApplicationContext(
			String[] configLocations) {
		ApplicationContext ctx = applicationContexts
				.get(configLocations);
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext(configLocations);
			applicationContexts.put(configLocations, ctx);
		}
		return ctx;
	}

}
