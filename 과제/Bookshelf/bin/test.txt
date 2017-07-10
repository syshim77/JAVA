// 12161605 심수연

import java.util.Scanner;

public class test
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		book[] book = new book[7];
		book[0] = new book("Harry Potter and the Deathly Hallows", new String[] {"J.K.Rowling", "Jim Kay", "Mary GrandPre"}, 784, 2009);
		book[1] = new book("A Song of Ice and Fire : 1-5 Boxed Set", new String[] {"George R. R. Martin"}, 5216, 2012);
		book[2] = new book("The Little Prince", new String[] {"Antoine De Saint-Exupery", "Richard Howard"}, 96, 2000);
		book[3] = new book("Percy Jackson and the Olympians 5 Book Paperback Boxed Set", new String[] {"Rick Riordan", "John Rocco"}, 1840, 2014);
		book[4] = new book("And Then There Were None", new String[] {"Agatha Christie"}, 272, 1939);
		book[5] = new book("The Murder of Roger Ackroyd",new String[] {"Agatha Christie"}, 312, 1926);
		book[6] = new book("Deep Learning", new String[] {"Lan Goodfellow", "Yoshua Bengio", "Aaron Courville"}, 800, 2016);

		bookshelf bookshelf = new bookshelf(book);

		int option_num = 0;
		String inputStr = null;		// 제목 키워드 입력받는 변수
		String inputStr2 = null;	// 작가 키워드 입력받는 변수
		book[] searchedBook;	// 찾은 책 목록
		
		while (option_num != 4)
		{
			System.out.println("Choose 1 option to search: ");
			System.out.println("1. Search by title.");
			System.out.println("2. Search by author.");
			System.out.println("3. Search by both.");
			System.out.println("4. Quit Program");
			System.out.print("User input: ");
			option_num = input.nextInt();

			switch (option_num)
			{
			case 1:
				System.out.print("Insert title keyword: ");
				inputStr = input.next();
				searchedBook = bookshelf.searchByTitle(inputStr);
				System.out.println("Found " + bookshelf.getBookHave() + " book(s).");
				for (int i = 0; i < bookshelf.getBookHave(); i++)
				{
					System.out.println(i + 1 + ". "	+ searchedBook[i]);
				}
				break;
			case 2:
				System.out.print("Insert author keyword: ");
				inputStr2 = input.next();
				searchedBook = bookshelf.searchByAuthor(inputStr2);
				System.out.println("Found " + bookshelf.getBookHave() + " book(s).");
				for (int i = 0; i < bookshelf.getBookHave(); i++)
				{
					System.out.println(i + 1 + ". "	+ searchedBook[i]);
				}
				break;
			case 3:
				System.out.print("Insert both(title and author) keyword: ");
				inputStr = input.next();
				inputStr2 = input.next();
				searchedBook = bookshelf.searchByBoth(inputStr, inputStr2);
				System.out.println("Found " + bookshelf.getBookHave() + " book(s).");
				for (int i = 0; i < bookshelf.getBookHave(); i++)
				{
					System.out.println(i + 1 + ". "	+ searchedBook[i]);
				}
				break;
			case 4:
				System.out.println("Quit program.");
				break;
			}
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
	}
}
