package crawler;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crawler_Main {
	
	String root;
	File folder;
	File[] listOfFiles;
	String search;
	
	ArrayList<String> file_content;
	ArrayList<String> file_paths;
	
	public Crawler_Main(){
		this.root = "E://LabN004";
		folder = new File(this.root);
		listOfFiles = folder.listFiles();
		file_content = new ArrayList<String>();
		file_paths = new ArrayList<String>();
	}
	public void walk( String path ) {

		File root = new File( path );
		File[] list = root.listFiles();

		if (list == null) return;

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				walk( f.getAbsolutePath() );
			}
			else {
				if(f.getName().contains(".txt")){
					file_content.add(parser(f));
					file_paths.add(f.getAbsolutePath());
				}
			}
		}
	}	
	
	public String parser(File f){
		List<String> lines = null;
		String con = "";
		try {
			lines = Files.readAllLines(Paths.get(f.getAbsolutePath()),StandardCharsets.UTF_8);
		} catch (IOException e) {}
		
		for(int i=0 ; i<lines.size(); i++ ){
			con += (String) lines.get(i);
		}
		return (con);
	}
	
	public void print(){
		for(int i=0; i< file_paths.size() ;i++){
			System.out.println(file_paths.get(i));
			System.out.println(file_content.get(i));
		}
	}

	public void search(String s){
		for (int i=0 ; i<file_paths.size() ; i++){
			if(file_paths.get(i).contains(s) || file_content.get(i).contains(s))
				System.out.println("Found At : "+file_paths.get(i));
		}
	}
	
	
	public static void main(String[] args) {
		
		Crawler_Main cm = new Crawler_Main();
		
		cm.walk("E://LabN004");
		
		System.out.println("Please enter a string to search:");
		
		Scanner s = new Scanner(System.in);
		
		String search = s.next();
		
		//cm.print();
		cm.search(search);
		
		
	}

}
