package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket server_socket;
	private Socket client_socket;

	private int port = 12003;
	
	public Server() throws IOException
	{
		server_socket = new ServerSocket(port);
		System.out.println("Server Started on port:: "+ port);
		
		while(true){
			client_socket = server_socket.accept();
			System.out.println("User Connected " + client_socket.getLocalAddress());				
			new Client(client_socket);
		}
	}
	
	public static void main(String a[]) throws IOException{
		
		Server server = null;
		System.out.println("Starting Server Please Wait...");

		try {
			server = new Server();
		} catch (IOException e) {}
		
		server.server_socket.close();
	}
}

