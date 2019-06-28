package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek1978 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] num = br.readLine().split(" ");
		int count = 0;
		
		for(int i = 0; i < num.length; i++) {
			int div = 0;
			for(int j = 1; j <= Integer.parseInt(num[i]); j++) {
				if(Integer.parseInt(num[i])%j == 0) div++;
			}

			if(div == 2) count++;
		}
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
}