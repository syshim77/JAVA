package Exercise1;

public class Card
{
	// 4 types of card suit
	public static final int DIAMOND = 1;
	public static final int CLUB = 2;
	public static final int HEART = 3;
	public static final int SPADE = 4;

	// String for printing purposes
	private static final String[] SUIT_STRING = { "*", "Diamond", "Club", "Heart", "Spade" };
	private static final String[] RANK_STRING = { "*", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	private int rank;
	private int suit;

	public Card()
	{
		this(1, 1);
	}
	// Two-argument constructor initializes Cards face and suit
	public Card(int rank, int suit)
	{
		setRank(rank);
		setSuit(suit);
	}

	// Getter method to return the face value
	public int getRank()
	{
		return rank;
	}
	public void setRank(int rank)
	{
		this.rank = rank;
	}

	// Getter method to return the suit value
	public int getSuit()
	{
		return suit;
	}
	public void setSuit(int suit)
	{
		this.suit = suit;
	}
	
	// Return String representation of Card objects
	public String toString()
	{
		return RANK_STRING[rank] + " of " + SUIT_STRING[suit];
	}
}
