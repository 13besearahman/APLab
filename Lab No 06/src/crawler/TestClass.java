package crawler;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestClass {

	@Test
	public void test1() {

		MainCrawler cm = new MainCrawler();
		assertEquals("E://LabN004", cm.root);
		
	}
	public void test2(){
		
		MainCrawler cm = new MainCrawler();
		File f = new File(cm.root);
		
		if(!f.exists()){
			fail("File not exist");
		}
	}
}
