package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1541 : Lost parenthesis
// Greedy algorithm, After processing all addition, subtraction is processed.
public class BOJ_1541 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] subtract_arr = br.readLine().split("-");
		boolean init_status_check = true;
		int result = 0;
		for(int i = 0; i < subtract_arr.length; ++i) {
			int sum = 0;
			
			String[] add_arr = subtract_arr[i].split("\\+");
			for(int j = 0; j < add_arr.length; ++j) {
				sum += Integer.parseInt(add_arr[j]);
			}
			
			if(init_status_check) {
				init_status_check = false;
				result = sum;
			}
			else {
				result -= sum;
			}
		}
		
		System.out.print(result);
	}
}