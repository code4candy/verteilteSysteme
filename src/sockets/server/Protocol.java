package sockets.server;

import java.util.ArrayList;
import java.util.List;

/**
 * find matching service and call its process method, 
 * which returns the calculated value as a String
 */
public class Protocol {

	public static String process(String[] input) {
		if(input.length >= 3) {
			Command commandService = Command.getService(input[0].toLowerCase()); 
			return commandService.process(input);
		}
		else {
			return "Input needs to be at least 3 Arguments.\n"
					+ "As first argument possible: add, substract, multiply\n"
					+ "As next arguments possible: two or more numbers to operate on\n"
					+ "e.g. \"add 2 3\" ";
		}
	}

}
