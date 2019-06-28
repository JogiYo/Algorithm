package baek10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek10989 {
	public static void main(String[]args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int[] a = new int[n];
		int[] b;
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			if(a[i] > max) max = a[i];
		}
		
		b = new int[max+1];
		for(int i = 0; i < a.length; i++)	b[a[i]]++;

		for(int i = 1; i < b.length; i++) {
			b[i] = b[i-1] + b[i];
		}
		
		for(int i = 0; i < b.length; i++) {
			if(i == 0) {
				for(int j = 0; j < b[i]; j++) {
					bw.write(0 + "\n");
				}
			}
			else {
				for(int j = 0; j < b[i] - b[i-1]; j++) {
					bw.write(i + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}