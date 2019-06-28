package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek1011 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int test_case = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		int dist,count;
		String[] input;
		
		for(int i = 0; i < test_case; i++) {
			input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			dist = y - x;
			
			if(dist == 1 || dist == 2) {
				count = dist;
			}
			else {
				long sum2 = 3;
				long sum1 = 0;
				int m;
				for(m = 2; dist > sum2; m++) {
					sum1 = sum2;
					sum2 += 2*m;
				}
				
				if((sum2-sum1)/2 + sum1 > dist) {
					count = (int) (sum2 - sum1 - 1);
				}
				else count = (int) (sum2 - sum1);
			}
			bw.write(String.valueOf(count) + "\n");		
		}
		bw.flush();
		bw.close();
	}
}