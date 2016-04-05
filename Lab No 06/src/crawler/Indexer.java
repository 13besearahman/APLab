package crawler;

import java.util.ArrayList;

public class Indexer implements Runnable {

	private ArrayList<String> file_content;
	private ArrayList<String> file_paths;
	private ArrayList<String> file_size;
	private ArrayList<String> last_Modified;
	private ArrayList<String> ownership;
	
	public Indexer(){
		this.file_content = new ArrayList<String>();
		this.file_paths = new ArrayList<String>();
		this.file_size = new ArrayList<String>();
		this.last_Modified = new ArrayList<String>();
		this.ownership = new ArrayList<String>();
	}
	
	public void run(){
		
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(CrawlerClass.file_content.size()>0){
				
				for(int i=0 ; i<CrawlerClass.file_content.size() ; i++ ){
					this.file_content.add(CrawlerClass.file_content.get(i));
					this.file_paths.add(CrawlerClass.file_paths.get(i));
					this.file_size.add(CrawlerClass.file_size.get(i));
					this.last_Modified.add(CrawlerClass.last_Modified.get(i));
					this.ownership.add(CrawlerClass.ownership.get(i));
					
					
				}
				CrawlerClass.file_content.clear();
				CrawlerClass.file_paths.clear();
				CrawlerClass.file_size.clear();
				CrawlerClass.last_Modified.clear();
				CrawlerClass.ownership.clear();
				
						
				for(int i=0 ; i<this.file_content.size() ; i++){
					MainCrawler.file_content.add(this.file_content.get(i));
					MainCrawler.file_paths.add(this.file_paths.get(i));
					MainCrawler.file_size.add(this.file_size.get(i));
					MainCrawler.last_Modified.add(this.last_Modified.get(i));
					MainCrawler.ownership.add(this.ownership.get(i));
					
				}
				
				this.file_content.clear();
				this.file_paths.clear();
				this.file_size.clear();
				this.last_Modified.clear();
				this.ownership.clear();
				
			}
		}
		
	}

}
