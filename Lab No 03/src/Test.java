import java.io.IOException;

import org.junit.Test;

import client.Client;
import server.Server;

public class Test {

	
	@Test
	public void ClientConnectiontest() {
		Client client = new Client();
		try {
			client.initConnection();
		} catch (IOException e) {}
	}
	
	@Test
	public void AstartServertest() {
		try {
			
			Server server = new Server();
			
		} catch (IOException e) {}
	}
	
	

	
	

}
