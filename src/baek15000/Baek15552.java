package baek15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] sum;
		
		for(int i = 0; i < n; i++) {
			sum = br.readLine().split(" ");
			bw.write(Integer.parseInt(sum[0])+Integer.parseInt(sum[1]) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
