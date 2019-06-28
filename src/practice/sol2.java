package practice;

public class sol2 {
	public static void main(String[] args) {
		String str = "";
		
		String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
		int count = 0;
		
		int a = 5; int b = 24;
		
		for(int i = 0; i < a-1; i++) {
			count += month[i];
		}
		count = (count+b-1)%7;
		str = days[count];
		
		System.out.print(days[count]);
		System.out.print(str);
		
	}
}
