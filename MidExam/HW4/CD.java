import java.util.Calendar;

public class CD extends Item {
	private String cdTitle;
	private String cdArtist;
	private int pubYear;

	// constructor
	CD(String id, int price, String title, String artist, int year) {
		super(id, price); // called superclass constructor
		cdTitle = title;
		cdArtist = artist;
		pubYear = year;
	}

	// get title method
	public String getCdTitle() {
		return cdTitle;
	}

	// get artist method
	public String getCdArtist() {
		return cdArtist;
	}

	// get published year method
	public int getPublishedYear() {
		return pubYear;
	}

	// return the info of the cd which i the title and the artist
	@Override
	String getInfo() {
		return cdTitle + " - " + cdArtist;
	}
	
	// implement getSalePrice method
	@Override
	public int getSalePrice() {
		int retPrice = 0;
		// get different between publish year and current year
		int diffYear = Calendar.getInstance().get(Calendar.YEAR)
				- getPublishedYear();

		// set the price base on the different year
		if (diffYear <= 1) {
			retPrice = (int) (getImportedPrice() * 1.5);
		} else if (diffYear <= 2) {
			retPrice = getImportedPrice();
		} else {
			retPrice = (int) (getImportedPrice() * 0.7);
		}
		return retPrice;
	}
}