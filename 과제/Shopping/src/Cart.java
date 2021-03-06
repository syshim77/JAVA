// 12161605 �ɼ���
public class Cart {
	int MAX_ITEM = 100;
	Item items[];
	int itemNum = 1;
	String buyerName;
	
	CD cd1 = new CD("CD001", "I am A Dreamer", "Park Hyo-shin", 2016, 20000);
	CD cd2 = new CD("CD007", "Foo Fighters", "Foo Fighters", 2005, 12500);
	CD cd3 = new CD("CD010", "King of Mask Singer episode 43-62", "Ha Hyun-woo", 2016, 30000);
	
	Movie mv1 = new Movie("MV002", "Interstellar", 2014, 14200);
	Movie mv2 = new Movie("MV004", "The Usual Suspects", 1995, 11000);
	Movie mv3 = new Movie("MV005", "Frozen", 2013, 11000);
	
	public Cart(String name) {
		this.buyerName = name;
	}
	
	public int getNumberOfItems() {
		return itemNum;
	}
	public boolean additem(Item i) {
		if (itemNum <= MAX_ITEM) {
			items[itemNum-1] = i;
			itemNum++;
			return true;
		}
		else
			return false;
	}
	public void printReceipt() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("1. " + mv1.getmovieTitle() + "                                       " + mv1.getSalePrice());
		System.out.println("2. " + cd3.toString() + "   " + cd3.getSalePrice());
		System.out.println("3. " + mv2.getmovieTitle() + "                                 " + mv2.getSalePrice());
		System.out.println("-----------------------------------------------------------");
		System.out.println("Total:                                               " + (mv1.getSalePrice()+cd3.getSalePrice()+mv2.getSalePrice()));
	}
}