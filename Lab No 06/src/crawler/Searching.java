package crawler;

public class Searching implements Runnable {
	
	public String search;
	
	public Searching(String s){
		this.search = s;
	}

	public void search(String s){
		for (int i=0 ; i<MainCrawler.file_paths.size() ; i++){
			if(MainCrawler.file_paths.get(i).contains(s) || MainCrawler.file_content.get(i).contains(s))
				System.out.println("Found At : "+MainCrawler.file_paths.get(i));
				System.out.println("Size of File is : "+MainCrawler.file_size.get(i));
				System.out.println("Las Modified at : "+MainCrawler.last_Modified.get(i));
				System.out.println("Ownership Status : "+MainCrawler.ownership.get(i));
				
				System.out.println();
		}
	}
	
	public void run() {
		search(this.search);
	}	
}
