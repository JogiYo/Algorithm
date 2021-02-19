package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 1037 : factor
// Use the properties of factors.
// I used two methods. Time and memory were consumed similarly.
public class BOJ_1037 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] factor = new int[n];
		String[] input = br.readLine().split(" ");
		
		for(int i = 0; i < n; ++i) {
			factor[i] = Integer.parseInt(input[i]);
		}
	
		sb.append(solution_1(n, factor) + ", " + solution_2(n, factor));
		System.out.print(sb);
	}
	
	public static int solution_1(int n, int[] factor) {
		int answer;
		// Sort the factors in ascending order.
		Arrays.sort(factor);
		// If the number of factors is odd, the median is multiplied twice.
		if(n%2 != 0) {
			int idx = n/2;
			answer = factor[idx] * factor[idx];
		}
		// If the number of factors is even, the minimum and maximum values ​​are multiplied.
		else {
			answer = factor[0] * factor[n-1];
		}
		
		return answer;
	}
	// Product of minimum and maximum values
	public static int solution_2(int n, int[] factor) {
		int answer;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; ++i) {
			max = factor[i] > max ? factor[i] : max;
			min = factor[i] < min ? factor[i] : min;
		}
		
		answer = max * min;
		return answer;
	}
}