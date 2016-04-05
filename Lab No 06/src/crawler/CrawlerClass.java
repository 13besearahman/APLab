package crawler;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CrawlerClass implements Runnable {
	
	public String root;
	
	public static ArrayList<String> file_content;
	public static ArrayList<String> file_paths;
	public static ArrayList<String> file_size;
	public static ArrayList<String> last_Modified;
	public static ArrayList<String> ownership;
	public CrawlerClass(String r){
		root = r;
		CrawlerClass.file_content = new ArrayList<String>();
		CrawlerClass.file_paths = new ArrayList<String>();
		CrawlerClass.file_size = new ArrayList<String>();
		CrawlerClass.last_Modified = new ArrayList<String>();
		CrawlerClass.ownership = new ArrayList<String>();
	}

	public void walk( String path ) {

		File root = new File( path );
		File[] list = root.listFiles();

		if (list == null) return;

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				try{
					walk( f.getAbsolutePath() );
				}catch(Exception e){}
			}
			else {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				
				if(f.getName().contains(".txt")){
					CrawlerClass.file_content.add(parser(f));
					CrawlerClass.file_size.add(""+f.length()+" Bytes");
					CrawlerClass.last_Modified.add(""+sdf.format(f.lastModified()));
					
					if(f.canRead())
						if(f.canRead())
							CrawlerClass.ownership.add("Read : True & Write : True");
						else
							CrawlerClass.ownership.add("Read : True & Write : False");
					else
						if(f.canRead())
							CrawlerClass.ownership.add("Read : False & Write : True");
						else
							CrawlerClass.ownership.add("Read : False & Write : False");
					
					CrawlerClass.file_paths.add(f.getAbsolutePath());
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
		return con;
	}

	public void run() {
		walk(this.root);
		
	}	
	
}
