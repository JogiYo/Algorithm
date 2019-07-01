package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ3052, Find the Number of different rests (using 1-dimensional Array)
public class Baek3052_one_dimension {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[42];
		int input;
		int count = 0;
		
		for(int i = 0; i < 10; i++) {
			input = Integer.parseInt(br.readLine());
			arr[input%42]++;
		}
		
		for(int i = 0; i < 42; i++) {
			if(arr[i] > 0) count++;
		}
		
		sb.append(count);
		System.out.print(sb);
	}
}