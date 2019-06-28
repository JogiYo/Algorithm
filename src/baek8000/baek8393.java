package baek8000;
import java.util.*;

public class baek8393 {
	public static void main(String[] args) {
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int x = 1; x <=n; x++) 	sum += x;
		
		System.out.println(sum);
	}
}
