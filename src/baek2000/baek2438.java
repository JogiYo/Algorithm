package baek2000;
import java.util.*;
public class baek2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<1 || n>100) n = sc.nextInt();
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<=x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}