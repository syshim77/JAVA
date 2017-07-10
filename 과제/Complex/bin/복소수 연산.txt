// 12161605 심수연
public class complex {
	private int x,y;
	
	public complex() {}	// 파라미터가 없는 생성자
	public complex (int x, int y) {	// 파라미터가 있는 생성자
		this.x = x;
		this.y = y;
	}
	
	public String Complex (int x, int y) {	// 복소수 형태로 출력하는 함수
		if (y>0) return String.format(x +"+"+ y +"i");
		else if (y==0) return String.format(x + "");
		else {
			int yy = 0-y;
			return String.format(x +"-"+ yy +"i");
		}
	}
	
	public int add (int x, int y) {	// 덧셈 함수
		return x+y;
	}
	public int sub (int x, int y) {	// 뺄셈 함수
		return x-y;
	}
	public int mul (int x, int y) {	// 곱셈 함수
		return x*y;
	}
	
	public static void main (String[] args) {
		int a=1; int b=3; int c=4; int d=-5;
		int p,q;
		
		complex c1 = new complex(a,b);
		complex c2 = new complex(c,d);
		
		System.out.println("First complex is: "
		+c1.Complex(a,b));
		System.out.println("Second complex is: "
		+c2.Complex(c,d));
		
		p = c1.add(a, c);
		q = c1.add(b, d);
		System.out.println("Result of addition is: "
		+c2.Complex(p,q));
		
		p = c1.sub(a, c);
		q = c1.sub(b, d);
		System.out.println("Result of subtraction is: "
		+c2.Complex(p, q));
		
		p = c1.mul(a, c) - c1.mul(b, d);
		q = c1.mul(a, d) + c1.mul(b, c);
		System.out.println("Result of multiplication is: "
		+c2.Complex(p, q));
	}
}
