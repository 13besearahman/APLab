package crawler;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCrawler {
	
	String root;
	File folder;
	File[] listOfFiles;
	
	public static ArrayList<String> file_content;
	public static ArrayList<String> file_paths;
	public static ArrayList<String> file_size;
	public static ArrayList<String> last_Modified;
	public static ArrayList<String> ownership;
	
	public MainCrawler(){
		this.root = "E://";
		folder = new File(this.root);
		listOfFiles = folder.listFiles();
		file_content = new ArrayList<String>();
		file_paths = new ArrayList<String>();
		file_size = new ArrayList<String>();
		last_Modified = new ArrayList<String>();
		ownership = new ArrayList<String>();
		
	}
	public String getroot(){
		return this.root;
	}
	public ArrayList<String> getFile_Content(){
		return MainCrawler.file_content;
	}
	public ArrayList<String> getFile_Path(){
		return MainCrawler.file_paths;
	}
	public ArrayList<String> getFile_size(){
		return MainCrawler.file_size;
	}
	public ArrayList<String> getlasModified(){
		return MainCrawler.last_Modified;
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		
		MainCrawler cm = new MainCrawler();
		
		Thread ind = new Thread(new Indexer());
		ind.setDaemon(true);
		ind.start();
		
		Thread CrawlerThread = new Thread(new CrawlerClass(cm.root));
		CrawlerThread.start();
		CrawlerThread.join();
		
		System.out.println("Please enter a string to search:");
		Scanner s = new Scanner(System.in);
		String search = s.next();
		
		Thread SearchThread = new Thread(new Searching( search));
		SearchThread.start();
		
		
		
	}

}
