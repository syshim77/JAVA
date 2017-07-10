abstract public class Item implements ForSale{
	private String itemID;
	private int importedPrice;

	//constructor
	Item(String id, int price) {
		itemID = id;
		importedPrice = price;
	}

	// get methods for ItemID
	public String getItemID() {
		return itemID;
	}

	// get methods for ImportPrice
	public int getImportedPrice() {
		return importedPrice;
	}
	
	// return the information of item
	abstract String getInfo();
}
