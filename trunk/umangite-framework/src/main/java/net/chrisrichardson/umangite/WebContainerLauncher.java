package net.chrisrichardson.umangite;

public interface WebContainerLauncher {

	void start() throws Exception;

	void stop() throws Exception;
	
	void setPort(int port);
	int getPort();
	
	void setContextPath(String contextPath);
	String getContextPath();

	int getActualPort();

}
