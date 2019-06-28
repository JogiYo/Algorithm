package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek10219 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			String[] hw = br.readLine().split(" ");
			int h = Integer.parseInt(hw[0]);
			int w = Integer.parseInt(hw[1]);
			String[][] grill = new String[h][w];
			
			for(int i = 0; i < h; i++) {
				String[] input = br.readLine().split("");
				for(int n = 0; n < w; n++) {
					grill[i][n] = input[n];
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int n = w-1; n >= 0; n--) {
					sb.append(grill[i][n]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}