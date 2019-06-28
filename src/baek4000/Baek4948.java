package baek4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek4948 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int count;
		
		while(n != 0) {
			count = 0;
			if(n == 1) bw.write(1 + "\n");
			else {
				for(int i = n+1; i <= 2*n; i++) {
					boolean flag = false;
					for(int j = 2; j < i; j++) {
						if(i%j == 0) {
							flag = true;
							break;
						}
					}
					if(!flag) count++;
				}
				bw.write(count + "\n");
			}
			n = Integer.parseInt(br.readLine());
		}
		bw.flush();
		bw.close();
	}
}