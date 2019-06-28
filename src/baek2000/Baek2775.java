package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_case; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k][n];
			int result;
			
			if(n == 1) {
				bw.write("1\n");
			}
			else {
				for(int t = 0; t < k; t++) {
					for(int y = 0; y < n; y++) {
						if(t == 0) {
							apart[t][y] = (y+2)*(y+1)/2;
						}
						else {
							if(y == 0) {
								apart[t][y] = 1;
							}
							else {
								apart[t][y] = apart[t-1][y] + apart[t][y-1];
							}
						}
					}
				}
				bw.write(apart[k-1][n-1]+"\n");
			}	
		}		
		bw.flush();
		bw.close();
	}
}