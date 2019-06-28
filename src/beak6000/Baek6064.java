package beak6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result,m,n,x,y;
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_case; i++) {
			String[] year = br.readLine().split(" ");
			m = Integer.parseInt(year[0]);
			n = Integer.parseInt(year[1]);
			x = Integer.parseInt(year[2]);
			y = Integer.parseInt(year[3]);
			int diff = (m-n)%n;
			int t;
			int target = 0;
			boolean flag = false;
			
			for(t = 1; t <= m; t++) {
				if(t%n == 0) target = n;
				else target = t%n;
				
				if(x==t) break;
			}
			
			if(target == y && x == t) {
				result = t;
			}
			else {
				for(t = 0; t < n; t++) {
					if(target <=0 ) target += n;
					else if(target > n) target -= n;
					
					if(target == y) {
						flag = true;
						break;
					}
					target += diff;
				}
				
				if(flag) {
					result = m*t + x;
				}
				else result = -1;
			}
			
			bw.write(result + "\n");	
		}
		bw.flush();
		bw.close();
	}
}