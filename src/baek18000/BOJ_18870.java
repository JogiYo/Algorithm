package baek18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BOJ 18870 : Coordinate compression
// using sorting array and HashMap
public class BOJ_18870 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] x = new int[n];
		
		for(int i = 0; i < n; ++i) {
			x[i] = Integer.parseInt(input[i]);
		}
		
		int[] sorted_x = x.clone();
		Arrays.sort(sorted_x);
		
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		
		for(int i = 0; i < sorted_x.length; ++i) {
			if(!map.containsKey(sorted_x[i])) map.put(sorted_x[i], idx++);
		}
		
		for(int i = 0; i < x.length; ++i) {
			sb.append(map.get(x[i]) + " ");
		}
		System.out.print(sb);
	}
}