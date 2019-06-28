package baek10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek10250 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_case; i++) {
			String[] input = br.readLine().split(" ");
			int h = Integer.parseInt(input[0]);      
			int w = Integer.parseInt(input[1]);
			int n = Integer.parseInt(input[2]);
			int result;
			
			if(n%h == 0) {
				result = h*100 + n/h;
			}
			else {
				result = (n%h)*100 + n/h + 1;
			}
			bw.write(String.valueOf(result+"\n"));
		}
		bw.flush();
		bw.close();
	}
}