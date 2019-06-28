package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak9252 {
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
		
		// °¡Àå ±ä LCS ±æÀÌ »Ì±â
		for(int i = 1; i < str2.length; i++) {
			LCS[i][0] = 0;
			
			for(int j = 1; j < str1.length; j++) {
				if(str2[i].equals(str1[j])) LCS[i][j] = LCS[i-1][j-1] + 1;
				else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				if(max < LCS[i][j]) max = LCS[i][j];
			}
		}
		
		sb.append(max + "\n");
		
		// LCS »Ì±â
		int temp0 , temp1, temp_j;
		temp1 = max;
		temp0 = temp1 - 1;
		temp_j = str1.length - 1;
		String lcs_str = "";
		
		for(int i = str2.length-1; i > 0; i--) {
			for(int j = temp_j; j > 0; j--) {
				if(LCS[i][j] == temp1 && LCS[i][j - 1] == temp0 && LCS[i - 1][j - 1] == temp0 && LCS[i - 1][j] == temp0) {
					temp0--;
					temp1--;
					lcs_str = str2[i] + lcs_str;
					temp_j = j;
					break;
				}

			}
		}
		
		sb.append(lcs_str);
		System.out.println(sb);
	}
}