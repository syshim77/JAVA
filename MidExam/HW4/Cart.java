public class Cart {
	final static int MAX_ITEM = 100;//max item limit
	private Item items[];//array of Item
	private String buyerName;
	private int itemNum;
	
	/**
	 * Constructor
	 * @param buyerName name of the buyer
	 */
	Cart(String buyerName) {
		this.buyerName = buyerName;
		items = new Item[MAX_ITEM];	//create array size of MAX_ITEM
		itemNum = 0;
		Math.sqrt(4);
	}  

	/**
	 * Get item has the index from 0..itemNum - 1
	 * @param idx 	index of items
	 * @return Item of placed index
	 */
	public Item getItemFromIndex(int idx) {
		return items[idx];
	}

	/**
	 * Get total item in cart
	 * @return total number
	 */
	public int getItemNumber() {
		return itemNum;
	}


	/**
	 * Add item into cart
	 * @param i item
	 * @return true if successful
	 */
	public boolean addItem(Item i) {
		if (itemNum < MAX_ITEM) {
			items[itemNum] = i;
			itemNum++;
			return true;
		} else  {
			return false;
		}
	}

	/**
	 * Print the list of item and price to screen
	 */
	public void printReceipt() {
		int total = 0;//total SalePrice
		System.out.println("Receipt:");
		System.out.println("Buyer: " + buyerName);
		System.out.println("-------------------------------------------------------------------");
		//print items title and salePrice
		for (int i = 0; i < itemNum; i++) {
			System.out.format("%d. %-50s %,10d W\n", 
					i + 1, items[i].getInfo(), items[i].getSalePrice());
			
			// increase the total price
			total += items[i].getSalePrice();
		}
		System.out.println("-------------------------------------------------------------------");
		//print total SalePrice
		System.out.format("%-33s %,30d W\n", "Total:", total);
	}
}
