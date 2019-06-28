package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2447 {
	private static char[][] starMap;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		starMap = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(starMap[i], ' ');
		}
		
		point(0, 0, n);
		for(int i = 0; i < n; i++) {
			System.out.println(starMap[i]);
		}
	}
	private static void point(int x, int y, int n) {
			if(n == 1) {
				starMap[x][y] = '*';
				return;
			}
			
			int div = n/3;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(i == 1 && j == 1) {
						continue;
					}
					point(x+div*i, y+div*j, div);
				}
			}
	}
}