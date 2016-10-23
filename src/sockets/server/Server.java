package sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

	static int SERVER_SOCKET = 8080;
	
	static String[] mapInput(String s) {
		return s.split(" ");
	}
	
	public static void main(String[] args) {
		String fromClient;
		
		try {
			//start server
			ServerSocket serverSocket = new ServerSocket(SERVER_SOCKET);
			System.out.println("...started server...");
			
			while (true) {
				//wait for message
				Socket clientSocket = serverSocket.accept();
				
				//send data
			    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			    //receive data
			    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
			    //read received data
				while ((fromClient = in.readLine()) != null) {
				    String[] mappedInput = mapInput(fromClient);
				    //debug-data
				    System.out.println("Client: " + fromClient);
				    System.out.println("calculated result: "+Protocol.process(mappedInput));
				    //send result back to client
				    out.println(Protocol.process(mappedInput));
				}
				
				//close connection
				clientSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sorry connection failed :-(");
		}
	}
}
