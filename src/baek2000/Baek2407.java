package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

//BigInteger와 pascal삼각형을 이용한 풀이
public class Baek2407 {
	static BigInteger pascal[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		pascal = new BigInteger[1001][1001];
		
		pascal[1][0] = pascal[1][1] = BigInteger.ONE;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j) {
					pascal[i][j] = BigInteger.ONE;
				}
				else {
					pascal[i][j] = pascal[i-1][j-1].add( pascal[i-1][j]);
				}
			}
		}
		sb.append(pascal[n][k]);
		System.out.println(sb);
	}
}