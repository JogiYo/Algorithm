package baek10000;
import java.util.Scanner;
public class Baek10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] result = {a,b,c};
		
		for(int i = 0; i < 3; i++) {
			int temp = result[i];
			for(int j = i+1; j < 3; j ++) {
				if(temp > result[j]) {
					result[i] = result[j];
					result[j] = temp;
					temp = result[i];
				}
			}
		}
		
		System.out.println(result[1]);
	}
}
