// 12161605 ½É¼ö¿¬
public class Movie extends Item implements ForSale {
	String movieTitle;
	int pubYear;
	int salePrice;
	
	public Movie(String id, String title, int pubyear, int price) {
		super(id, price);
		this.movieTitle = title;
		this.pubYear = pubyear;
	}
	
	public void setmovieTitle(String title) {
		this.movieTitle = title;
	}
	public String getmovieTitle() {
		return movieTitle;
	}
	public void setpubYear(int pubyear) {
		this.pubYear = pubyear;
	}
	public int getpubYear() {
		return pubYear;
	}
	public int getSalePrice() {
		if (pubYear >= 2016)
			salePrice = 2*importPrice;
		else
			salePrice = importPrice/2;
		
		return salePrice;
	}
}