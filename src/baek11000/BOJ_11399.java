package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 11399 : ATM
// Greedy algorithm
public class BOJ_11399 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < n; ++i) {
			time[i] = Integer.parseInt(input[i]);			
		}
		
		int result = solution(time);
		System.out.print(result);
	}

	private static int solution(int[] time) {
		int total = 0;
		int sum = 0;
		Arrays.sort(time);
		
		for(int i = 0; i < time.length; ++i) {
			sum = sum + time[i];
			total += sum;
		}
		return total;
	}
}