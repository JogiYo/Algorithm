package baek11000;
import java.util.Scanner;

public class Baek11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		for(int i = 0; i < word.length(); i++) {
			if(i%10 == 0 && i !=0) System.out.println();
			System.out.print(word.charAt(i));
		}
		
	}
}
