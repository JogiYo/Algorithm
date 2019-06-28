package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2562 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[9];
		int max = 0;
		int max_index = 0;
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
				max_index = i;
			}
		}
		
		sb.append(max + "\n" + (max_index+1));
		System.out.print(sb);
	}
}