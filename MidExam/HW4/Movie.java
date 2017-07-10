import java.util.Calendar;

public class Movie extends Item {
	private String movieTitle;
	private int pubYear;

	// constructor
	Movie(String id, int price, String title, int year) {
		super(id, price); // called superclass constructor
		movieTitle = title;
		pubYear = year;
	}

	// get title method
	public String getMovieTitle() {
		return movieTitle;
	}

	// get published year method
	public int getPublishedYear() {
		return pubYear;
	}

	// return the title of the movie 
	@Override
	String getInfo() {
		return movieTitle;
	}

	// implement getSalePrice method
	@Override
	public int getSalePrice() {
		int retPrice;
		// get different between publish year and current year
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int diffYear = curYear - getPublishedYear();

		// set the price base on the different year
		if (diffYear <= 1) {
			retPrice = getImportedPrice() * 2;
		} else {
			retPrice = getImportedPrice() / 2;
		}
		return retPrice;
	}
}
