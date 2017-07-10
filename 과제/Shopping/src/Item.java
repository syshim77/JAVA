// 12161605 ½É¼ö¿¬
public class Item {
	String itemID;
	int importPrice;
	
	public Item(String id, int price) {
		this.itemID = id;
		this.importPrice = price;
	}
	
	public void setID(String id) {
		this.itemID = id;
	}
	public String getID() {
		return itemID;
	}
	public void setPrice(int price) {
		this.importPrice = price;
	}
	public double getPrice() {
		return importPrice;
	}
}