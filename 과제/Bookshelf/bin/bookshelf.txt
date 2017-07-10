// 12161605 심수연

public class bookshelf
{
	private int bookCapacity;	// 전체 책의 수
	private int bookHave;	// 찾은 책의 수
	private int searchCount;	// 찾은 책을 searchBooks에 넣을때 사용하는 변수
	private book[] books;	// 전체 책 목록
	private book[] searchBooks;	// 찾은 책 목록

	public bookshelf(book[] book)	// 생성자
	{
		bookCapacity = book.length;
		bookHave = 0;
		this.books = book;
	}

	public int getBookHave()
	{
		return bookHave;
	}

	public void setBookHave(int bookHave)
	{
		this.bookHave = bookHave;
	}

	public book[] searchByTitle(String keyword)	// 제목으로 책 찾는 함수
	{
		bookHave = 0;
		searchCount = 0;
		
		for (int i = 0; i < bookCapacity; i++)	// 조건에 맞는 책 개수 세기
		{
			if (books[i].getTitle().contains(keyword))	
					bookHave++;
		}
		
		searchBooks = new book[bookHave];
		
		for (int i = 0; i < bookCapacity; i++)	// 조건에 맞는 책의 정보를 searchBooks 배열에 저장
		{
			if (books[i].getTitle().contains(keyword))
					searchBooks[searchCount++] = books[i];
		}

		return searchBooks;
	}

	public book[] searchByAuthor(String keyword)	// 작가로 책 찾는 함수
	{
		bookHave = 0;
		searchCount = 0;
		
		for (int i = 0; i < bookCapacity; i++)	// 조건에 맞는 책 개수 세기
		{
			for (int j = 0; j < books[i].getAuthors().length; j++)
			{
				if (books[i].getAuthors()[j].contains(keyword))
				{
					bookHave++;
					break;
				}
			}
		}
		
		searchBooks = new book[bookHave];
		
		for (int i = 0; i < bookCapacity; i++)	// 조건에 맞는 책 정보를 searchBooks 배열에 저장
		{
			for (int j = 0; j < books[i].getAuthors().length; j++)
			{
				if (books[i].getAuthors()[j].contains(keyword))
				{
					searchBooks[searchCount++] = books[i];
					break;
				}
			}
		}
		
		return searchBooks;
	}

	public book[] searchByBoth(String keyword_t, String keyword_a)	// 제목과 작가 둘다 이용해서 책 찾는 함수
	{
		bookHave = 0;
		searchCount = 0;
		
		for (int i = 0; i < bookCapacity; i++)
		{
			if (books[i].getTitle().contains(keyword_t))	// 제목 키워드 있는지 검사
			{
				for (int j = 0; j < books[i].getAuthors().length; j++)
				{
					if (books[i].getAuthors()[j].contains(keyword_a))	// 작가 키워드 있는지 검사
					{
						bookHave++;
						break;
					}
				}	
			}
		}
		
		searchBooks = new book[bookHave];
		
		for (int i = 0; i < bookCapacity; i++)
		{
			if (books[i].getTitle().contains(keyword_t))	// 제목 키워드 있는지 검사
			{
				for (int j = 0; j < books[i].getAuthors().length; j++)
				{
					if (books[i].getAuthors()[j].contains(keyword_a))	// 작가 키워드 있는지 검사
					{
						searchBooks[searchCount++] = books[i];
						break;
					}
				}
			}
		}
		
		return searchBooks;
	}
}