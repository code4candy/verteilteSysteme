package sockets.server;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

public class TestServer {

	@Test
	public void testProtocolOnAdd() {
		String[] input = {"Add", "2", "3"};
		assertEquals("5.0", Protocol.process(input));
	}
	
	@Test
	public void testProtocolOnSubstract() {
		String[] input = {"Substract", "2", "3"};
		assertEquals("-1.0", Protocol.process(input));
	}
	
	@Test
	public void testProtocolOnMultiply() {
		String[] input = {"Multiply", "2", "3"};
		assertEquals("6.0", Protocol.process(input));
	}
	
	@Test
	public void testServerMapInput() {
		String input = "Multiply 4 3";
		assertArrayEquals(new String[] {"Multiply", "4", "3"}, Server.mapInput(input));
	}
	
}
