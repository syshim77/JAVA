// 12161605 ½É¼ö¿¬
public class CD extends Item implements ForSale {
	String cdTitle;
	String cdArtist;
	int pubYear;
	int salePrice;
	
	public CD(String id, String title, String artist, int pubyear, int price) {
		super(id, price);
		this.cdTitle = title;
		this.cdArtist = artist;
		this.pubYear = pubyear;
	}
	
	public void setcdTItle(String title) {
		this.cdTitle = title;
	}
	public String getcdTitle() {
		return cdTitle;
	}
	public void setcdArtist(String artist) {
		this.cdArtist = artist;
	}
	public String getcdArtist() {
		return cdArtist;
	}
	public void setpubYear(int pubyear) {
		this.pubYear = pubyear;
	}
	public int getpubYear() {
		return pubYear;
	}
	public String toString() {
		return cdTitle + " - " + cdArtist;
	}
	public int getSalePrice() {
		if (pubYear >= 2016)
			salePrice = importPrice + importPrice/2;
		else if (2015 <= pubYear && pubYear < 2016)
			salePrice = importPrice;
		else
			salePrice = (7*importPrice)/10;
		
		return salePrice;
	}
}