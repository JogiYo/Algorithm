package baek1000;
import java.util.*;
public class baek1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int sum = 0;
		int day_cal;
		
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] day = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for(int t = 1; t < x; t++) {
				sum += month[t-1];
		}
		
		sum += y;
		day_cal = sum % 7;
		System.out.println(day[day_cal]);
	}
}
