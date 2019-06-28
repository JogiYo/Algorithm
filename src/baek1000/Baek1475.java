package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek1475 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] n = br.readLine().split("");
		int result;
		int count;
		int max_count = 1;
		
		for(int i = 0; i < n.length-1; i++) {
			count = 1;
			if(n[i].charAt(0) == 54 || n[i].charAt(0) == 57) {
				for(int t = i+1; t < n.length; t++) {
					if(n[t].charAt(0) == 54 || n[t].charAt(0) == 57) {
						count++;
					}
				}
				if(count % 2 == 0) count = count/2;
				else count = count/2 + 1;
			}
			else {
				for(int t = i+1; t < n.length; t++) {
					if(n[i].charAt(0) == n[t].charAt(0)) {
						count++;
					}
				}
			}
			if(max_count < count) max_count = count;
		}
		bw.write(max_count+"\n");
		bw.flush();
		bw.close();
	}
}