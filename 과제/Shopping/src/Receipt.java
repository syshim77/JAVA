// 12161605 ½É¼ö¿¬
public class Receipt {
	public static void main(String[] args) {
		Item Item[] = new Item[3];
		Item[0] = new Movie("MV002", "Interstellar", 2014, 14200);
		Item[1] = new CD("CD010", "King of Mask Singer episode 43-62", "Ha Hyun-woo", 2016, 30000);
		Item[2] = new Movie("MV004", "The Usual Suspects", 1995, 11000);
		
		Cart cart = new Cart("Shim Soo Yeon");
		
		System.out.println("Receipt: ");
		System.out.println("Buyer: " + cart.buyerName);
		cart.printReceipt();
		System.out.println();
	}
}