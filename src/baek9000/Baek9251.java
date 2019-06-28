package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// LCS를 구하는 방법,, https://twinw.tistory.com/126 내용 참고
// dynamic programming
public class Baek9251 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str1 = ("0"+br.readLine()).split("");
		String[] str2 = ("0"+br.readLine()).split("");
		int max = 0;
		
		int[][] LCS = new int[str2.length][str1.length];
		
		for(int i = 0; i < str1.length; i++) {
			LCS[0][i] = 0;
		}
	
		for(int i = 1; i < str2.length; i++) {
			LCS[i][0] = 0;
			
			for(int j = 1; j < str1.length; j++) {
				if(str2[i].equals(str1[j])) LCS[i][j] = LCS[i-1][j-1] + 1;
				else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				if(max < LCS[i][j]) max = LCS[i][j];
			}
		}
		sb.append(max);
		System.out.println(sb);
	}
}