package sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	private static int SERVER_PORT = 8080;

	private static String EXPLANATION = "Input needs to be at least 3 Arguments.\n"
			+ "As first argument possible: add, substract, multiply\n"
			+ "As next arguments possible: two or more numbers to operate on\n"
			+ "Example input: \"add 2 3\" ";

	private static String mapToString(String[] input) {
		String mappedInput = "";
		for(String s : input) {
			mappedInput += s + " ";
		}
		return mappedInput;
	}

	public static void main(String[] args) {
		String fromServer;
		String userInput = mapToString(args);

		try {
			// socket = target-ip + target-port
			Socket client = new Socket(InetAddress.getLocalHost(), SERVER_PORT); 
			System.out.println("*** Connected to server. ***");

			//send & receive
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

			//write to server
			//println => automatically sets carriage return => not working without
			if(args.length > 2 && !userInput.isEmpty()) {
				out.println(userInput);
				System.out.println("Send To Server: " + userInput);
			}
			else {
				System.out.println("Please enter your arguments:\n");
				
				// readLine() - blocks till carriage return gets received
				// is null at the end of textlines
				while ((userInput = stdIn.readLine()) != null) {
					out.println(userInput);
					System.out.println("Send To Server: " + userInput);
				}
			}

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
			}

			//out & in don't need to get closed separately
			client.close();
			System.out.println("*** Connection to server closed. ***");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("*** Connection failed :-( ***");
		} 
	}

}
