package net.chrisrichardson.umangite;

import junit.framework.TestCase;

public class PortUtilTests extends TestCase {
	
	public void testAllocatePort() throws InterruptedException {
		int port1 = PortUtil.allocatePort();
		assertTrue(port1 > 0);
		int port2 = PortUtil.allocatePort();
		assertTrue(port2 > 0);
		assertFalse(port1 == port2);
	}

	public void testAllocatePortIfRequired_required() {
		int port = PortUtil.allocatePortIfRequired(-1);
		assertTrue(port > 0);
	}

	public void testAllocatePortIfRequired_not_required() {
		int port = PortUtil.allocatePortIfRequired(50);
		assertEquals(50, port);
	}

}
