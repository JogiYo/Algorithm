package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1003_dynamic {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[][] fibo = new int[41][2];
		
		fibo[0][0] = 1;
		fibo[1][1] = 1;
		
		for(int i = 2; i < 41; i++) {
			for(int j = 0; j < 2; j++) {
				fibo[i][j] = fibo[i-1][j] + fibo[i-2][j];
			}
		}
		
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(fibo[input][0] + " " + fibo[input][1] +"\n");
		}
		
		System.out.print(sb);
	}
}