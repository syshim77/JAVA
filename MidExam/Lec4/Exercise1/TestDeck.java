package Exercise1;

public class TestDeck
{
	public static void main(String[] args)
	{
		Deck deck = new Deck();  // Create deck object
		deck.shuffle();  // Place Cards in random order
		
		// Print all 52 Cards in the order in which they are dealt
		for (int i = 1; i <= 52; i++)
		{
			// Deal and display a Card
			System.out.printf("%-19s", deck.deal());
			
			if (i % 4 == 0)  // Output a newline after every fourth card
			{
				System.out.println();
			}
		} // end for
	}
}