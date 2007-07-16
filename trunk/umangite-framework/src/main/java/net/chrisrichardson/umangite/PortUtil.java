package net.chrisrichardson.umangite;

import java.io.IOException;
import java.net.ServerSocket;

public class PortUtil {

	public static int allocatePort() {
		try {
			ServerSocket s = new ServerSocket();
			s.bind(null);
			int port = s.getLocalPort();
			s.close();
			return port;
		} catch (IOException e) {
			throw new UmangiteException("Couldn't allocate port", e);
		}
	}

	public static int allocatePortIfRequired(int port) {
		return port == -1 ? allocatePort() : port;
	}


}
