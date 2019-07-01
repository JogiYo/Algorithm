package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ10818, Find the maximum and minimum value of n integers
public class Baek10818 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		int num;
		
		for(int i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num > max) max = num;
			if(num < min) min = num;
		}
		
		sb.append(min + " " + max);
		System.out.print(sb);
	}
}