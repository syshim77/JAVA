package Exercise1;

import java.util.Random;

public class Deck
{
	// Array to store 52 cards
	private final int TOTAL_CARDS = 52;
	private Card deck[];
	
	// Random object for shuffling cards
	private Random randGener;
	
	// Store the position of the top card
	private int curCard;
	
	// No-argument constructor fills the deck of cards
	public Deck()
	{
		// IMPORTANT: We must create the array first!
		deck = new Card[TOTAL_CARDS];
		randGener = new Random();
		
		int i = 0;
		for (int suit = Card.DIAMOND; suit <= Card.SPADE; suit++)
		{
			for (int rank = 1; rank <= 13; rank++)
			{
				deck[i++] = new Card(rank, suit);  // Put card in position i
			}
		}
		curCard = 0;
	}
	
	// Shuffles the deck
	public void shuffle()
	{
		for (int i = 0; i < deck.length; i++)
		{
			int j = randGener.nextInt(TOTAL_CARDS);
			Card c = deck[i];
			deck[i] = deck[j];
			deck[j] = c;
		}
	}
	
	// Returns the individual card in the deck
	public Card deal()
	{
		if (curCard >= TOTAL_CARDS)
		{
			System.out.println("Out of cards error!");
			return null;  // Error
		}
		else
		{
			return (deck[curCard++]);
		}
	}
}
