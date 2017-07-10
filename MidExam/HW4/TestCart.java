public class TestCart {

	public static void main(String[] args) {
		// create Cart
		Cart myCart = new Cart("Me");
		
		//create the items and add into cart
		myCart.addItem(new CD("CD001",20000,"I am A Dreamer","Park Hyo-shin",2016));
		myCart.addItem(new Movie("MV002",14200,"Interstellar",2014));
		myCart.addItem(new CD("CD007",12500,"Foo Fighters","Foo Fighters",2005));
		myCart.addItem(new Movie("MV004",11000,"The Usual Suspects",1995));
		myCart.addItem(new CD("CD010",30000,"King of Mask Singer episode 43-62","Ha Hyun-woo",2016));
		myCart.addItem(new Movie("MV005",11000,"Frozen",2013));
		
		//print Receipt
		myCart.printReceipt();
	}

}