import java.util.Arrays;

public class Book {
	String title;
	String[] authors;
	int page;
	int pubYear;
	
	Book(String title,String[] authors,int page,int pubYear){
		this.title=title;
		this.authors=authors;
		this.page=page;
		this.pubYear=pubYear;
	}
	
	public String GetterTitle() {
		return title;
	}

	public void Setter(String title) {
		this.title = title;
	}
	
	public String[] GetterAuthor() {
		return authors;
	}
	
	
	public String toString(){
		
		return (GetterTitle() + " - " + Arrays.asList(GetterAuthor()) + " - " + page + " page" + " - " + pubYear);
		
	}
}
