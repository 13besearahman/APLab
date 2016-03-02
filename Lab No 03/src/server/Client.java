package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {

	private user_notes.User_Notes notes;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public Client(Socket sock)
	{
		String username = null;
		try{
			ois = new ObjectInputStream(sock.getInputStream());
			oos = new ObjectOutputStream(sock.getOutputStream());
			
			username = (String) ois.readObject();
		}
		catch (IOException | ClassNotFoundException e) {System.out.println(3);}
		
		
		notes = new user_notes.User_Notes(username);
		readFileForNotes(username);
		
		try {
			oos.writeObject(notes);
			oos.flush();
		} catch (IOException e) {System.out.println(4);}
		
	}

	private void readFileForNotes(String username) {
		File file = new File(username + ".ser");
		
		if(file.exists())
		{
			FileInputStream fileInputStream = null;
			try 
			{
				fileInputStream = new FileInputStream(file);
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				ObjectInputStream in = new ObjectInputStream(fileInputStream);	
				notes = (user_notes.User_Notes) in.readObject();
				in.close();
				fileInputStream.close();
			} 
			catch (ClassNotFoundException | IOException e) 
			{
				e.printStackTrace();
			} 
			
		}
		else
		{
			try 
			{
				file.createNewFile();
				updateNotes(notes);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void updateNotes(user_notes.User_Notes mynotes) throws IOException 
	{
		File file = new File(notes.getUsername() + ".notes");
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(mynotes);

		objectOutputStream.close();
		outputStream.close();
	}

	public void run()
	{
		while(true)
		{
			try {
				notes = (user_notes.User_Notes) ois.readObject();
				updateNotes(notes);
			} 
			catch (ClassNotFoundException e) { System.out.println(1);}
			catch (IOException e) {System.out.println(2);}	
		}
	}

	

	
}
