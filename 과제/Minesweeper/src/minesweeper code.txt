import java.util.Scanner;
import java.util.Random;

public class third {
	
	public static void main(String[] args) {
		int row; int column; int bomb;
		int x; int y; int cnt=0;
		String[][] ms;
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		System.out.printf("Enter the number rows: ");
		row=scan.nextInt('\n');
		System.out.printf("Enter the number of columns: ");
		column=scan.nextInt('\n');
		System.out.printf("Enter the number of bomb: ");
		bomb=scan.nextInt('\n');
		
		ms = new String[row][column];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				ms[i][j]="-";
			}
		}
		
		for (int i=0; i<bomb; i++) {
			x=ran.nextInt(row); y=ran.nextInt(column);
			if (ms[x][y]=="*") {
				i--; continue;
			}
			ms[x][y]="*";
		}
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				if (ms[i][j] == "-") {
					if (i-1>=0 && j-1>=0 && ms[i-1][j-1] == "*") cnt++;
					if (i-1>=0 && ms[i-1][j] == "*") cnt++;
					if (i-1>=0 && j+1<column && ms[i-1][j+1] == "*") cnt++;
					if (j-1>=0 && ms[i][j-1] == "*") cnt++;
					if (j+1<column && ms[i][j+1] == "*") cnt++;
					if (i+1<row && j-1>=0 && ms[i+1][j-1] == "*") cnt++;
					if (i+1<row && ms[i+1][j] == "*") cnt++;
					if (i+1<row && j+1<column && ms[i+1][j+1] == "*") cnt++;
					
					if (cnt == 0) {
						ms[i][j] = "-"; continue;
					}
					ms[i][j]="" + cnt;
					cnt=0;
				}
			}
		}
		
		System.out.println("This is bomb map: ");
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				System.out.printf(ms[i][j] + " ");
			}
			System.out.println();
		}
	}
}
