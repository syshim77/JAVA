import java.util.Scanner;


public class Bookshelf { //Bookshelf 객체 생성
	private int bookCapacity; // 선반 용량
	private int bookHave; //가지고 있는 책의 개수
	Book[] books; // Book[] 배열 선언
	
	Bookshelf(){
		bookCapacity=10;
		bookHave=5;
		books = new Book[bookHave]; // Book[] 클래스 배열 만들어줌
		books[0]=new Book("Harry Potter and the Deathly Hallows",new String[]{"J.K. Rowling","Jim Kay","Mary GrandPre"}, 784, 2009); //book[0]부터 [4]까지 초기화하면서 선언해줌
		books[1]=new Book("Harry Potter and the Sorcerer's Stone",new String[]{"J.K. Rowling","Mary GrandPre"}, 312, 1999);
		books[2]=new Book("A Song of Ice and Fire : 1-5 Boxed Set",new String[]{"George R. R. Martin"}, 5216, 2012);
		books[3]=new Book("The Little Prince",new String[]{"Antoine De Saint-Exupery","Richard Howard"}, 96, 2000);
		books[4]=new Book("Percy Jackson and the Olympians 5 Book Paperback Boxed Set",new String[]{"Rick Riordan"," John Rocco"}, 1840, 2014);
	}
	
	
	Book searchByTitle(String keyword,int test){
		if(books[test].title.contains(keyword)){
			return books[test];
		}
		else
			return null;
	}
	
	Book searchByAuthor(String keyword,int test){
		int k = books[test].authors.length;
		for(int i=0;i<k;i++){
			if(books[test].authors[i].contains(keyword)){
				return books[test];
			}
		}
		return null;
	}
	
	Book searchByBoth(String keyword,int test){
		int k=books[test].authors.length;
		for(int i=0;i<k;i++){
			if(books[test].authors[i].contains(keyword)||books[test].title.contains(keyword)){
				return books[test];
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Bookshelf book = new Bookshelf();
		System.out.println("Choose 1 option to search:");
		System.out.println("1. Search by title.");
		System.out.println("2. Search by author");
		System.out.println("3. Search by both.");
		System.out.print("User input: ");
		Scanner input =new Scanner(System.in);
		int choose = input.nextInt();
		if(choose>3 || choose<1){
			System.out.println("Select correct Number");
		}
		else{
			switch (choose){
				case 1:
					System.out.print("Insert title keyword: ");
					Scanner input1 = new Scanner(System.in);
					String keyword1=input1.nextLine();
					System.out.printf("Found books \n");
					System.out.printf("%s\n%s\n%s\n%s\n%s",book.searchByTitle(keyword1,0),book.searchByTitle(keyword1,1),book.searchByTitle(keyword1,2),book.searchByTitle(keyword1,3),book.searchByTitle(keyword1,4));
					break;
				case 2:
					System.out.print("Insert author keyword: ");
					Scanner input2 = new Scanner(System.in);
					String keyword2=input2.nextLine();
					System.out.printf("Found books \n");
					System.out.printf("%s\n%s\n%s\n%s\n%s",book.searchByAuthor(keyword2,0),book.searchByAuthor(keyword2,1),book.searchByAuthor(keyword2,2),book.searchByAuthor(keyword2,3),book.searchByAuthor(keyword2,4));
					break;
				case 3:
					System.out.print("Insert both keyword: ");
					Scanner input3 = new Scanner(System.in);
					String keyword3=input3.nextLine();
					System.out.printf("Found books \n");
					System.out.printf("%s\n%s\n%s\n%s\n%s",book.searchByBoth(keyword3,0),book.searchByBoth(keyword3,1),book.searchByBoth(keyword3,2),book.searchByBoth(keyword3,3),book.searchByBoth(keyword3,4));
					break;
			}
		}
	}
}