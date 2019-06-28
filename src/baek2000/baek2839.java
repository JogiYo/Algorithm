package baek2000;
import java.util.*;

public class baek2839 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		if(n<3 || n>5000) {
			n = scanner.nextInt();
		}
		
		int five, three;
		
		if(n%5 == 0) {
			five = n/5;
			System.out.println(five);
		}
		
		else {
			int init_five = five = n/5;
			int five_remain = n%5;
			int x;
			
			for(x=init_five; x>=0; x-- ) {
				
				if(five_remain%3 == 0) {
					three = five_remain/3;
					System.out.println(five + three);
					break;
				}
				else {
					five = five - 1;
					five_remain = five_remain + 5;
				}
			}
			
			if (x == -1) System.out.println(x);
			
		}	
	}
}
