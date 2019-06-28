package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek9461 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		long[] pn = new long[101];
		
		for(int i = 1; i <= 2; i++) {
			pn[i] = 1;
		}
		
		for(int i = 3; i <= 100; i++) {
			pn[i] = pn[i-3] + pn[i-2];
		}
		
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(pn[n] + "\n");
		}
		
		System.out.print(sb);
	}
}