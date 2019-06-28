package baek2000;
import java.util.*;
public class baek2739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if (n < 1 || n>9) n = sc.nextInt();
		
		for(int x = 1; x < 10; x++) {
			System.out.println(n + " * " + x + " = " + n*x);
		}
	}
}
