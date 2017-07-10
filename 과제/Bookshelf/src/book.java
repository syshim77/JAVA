// 12161605 심수연

import java.util.Arrays;

public class book
{
	private String title;
	private String[] authors;
	private int page;
	private int pubYear;
	
	public book(String title, String[] authors, int page, int pubYear)	// 생성자
	{
		setTitle(title);
		setAuthors(authors);
		setPage(page);
		setPubYear(pubYear);
	}
	
	public String getTitle()	// title 반환 함수
	{
		return title;
	}

	public void setTitle(String title)	// title 입력 함수
	{
		this.title = title;
	}
	
	public String[] getAuthors()	// authors 반환 함수
	{
		return authors;
	}

	public void setAuthors(String[] authors)	// authors 입력 함수
	{
		this.authors = authors;
	}

	public int getPage()	// page 반환 함수
	{
		return page;
	}

	public void setPage(int page)	// page 입력 함수
	{
		this.page = page;
	}

	public int getPubYear()	// pubYear 반환 함수
	{
		return pubYear;
	}

	public void setPubYear(int pubYear)	// pubYear 입력 함수
	{
		this.pubYear = pubYear;
	}

	public String toString()	// 책 정보(title, authors, page, pubYear) 반환 함수
	{
		return title + " - " + Arrays.toString(authors) + " - " + page + " pages - " + pubYear + ".";
	}
	
}
