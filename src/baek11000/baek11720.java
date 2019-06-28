package baek11000;
import java.util.Scanner;
public class baek11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n>100 || n<1) n = sc.nextInt(); 
		
		String temp = sc.next();
		int sum = 0;
		
		for(int i=0; i < n; i++) {
			sum += temp.charAt(i)-'0';
		}
		
		System.out.println(sum);
	}
}
