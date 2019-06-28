package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek1427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] n = br.readLine().split("");
		String min = "";
		
		for(int i = 0; i < n.length-1; i++) {
			for(int j = 1; j < n.length - i; j++) {
				if(n[j].charAt(0) > n[j-1].charAt(0)) {
					min = n[j-1];
					n[j-1] = n[j];
					n[j] = min;
				}
			}
		}
		
		for(int i = 0; i < n.length; i++) {
			bw.write(n[i]);
		}
		bw.flush();
		bw.close();
	}
}