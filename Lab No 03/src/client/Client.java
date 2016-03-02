package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Scanner scanner;
	private Socket socket;
	private int port = 12003;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private user_notes.User_Notes notes;
	
	public void startClient() throws IOException, InterruptedException, ClassNotFoundException
	{
		{
			socket = new Socket("localhost", port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		}
		
		System.out.println("Connected to Server");
		System.out.println("Please Enter Your Name");
		scanner = new Scanner(System.in);

		notes = new user_notes.User_Notes(scanner.nextLine());
		oos.writeObject(notes.getUsername());
		
		notes = (user_notes.User_Notes) ois.readObject();
		System.out.println("Notes Updat");
		
		logicClient();
	}

	private void logicClient() throws IOException, InterruptedException {
		Boolean keepGoing = true;

		while(keepGoing){
			
			System.out.println("Press 1 to add new Notes");
			System.out.println("Press 2 to show all your notes");

			System.out.println("Press 3 to exit");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("Please Enter Text note");
				scanner.nextLine();
				String newNote = scanner.nextLine();
				notes.getNotes().add(newNote);
				{
					oos.writeObject(notes);
				}
				break;
			case 2:
				System.out.println("");
				for(String note: notes.getNotes())
				{
					System.out.println(note);
				}
				System.out.println("End Notes press enter to continue");
				scanner.nextLine();
				scanner.nextLine();
				
				break;

			case 3:
				keepGoing = false;
				break;
				
			default:
				System.out.println("Wrong Entry");
				break;
			}
			Thread.sleep(100);
		}
	}
	
	public void initConnection() throws IOException {

		try {
			socket = new Socket("localhost", port);

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {
			throw e;
		}
	}


	public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {
		
		Client client = new Client();
		client.startClient();
		
	}

}





