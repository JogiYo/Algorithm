package baek5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek5622 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			int count = 0;
			
			for(int i = 0; i < s.length(); i++) {
				int a = s.charAt(i);
				
				if(a >= 65 && a < 68) count += 3;
				else if(a >= 68 && a < 71) count += 4;
				else if(a >= 71 && a < 74) count += 5;
				else if(a >= 74 && a < 77) count += 6;
				else if(a >= 77 && a < 80) count += 7;
				else if(a >= 80 && a < 84) count += 8;
				else if(a >= 84 && a < 87) count += 9;
				else if(a >= 87 && a < 91) count += 10;
			}
			
			bw.write(count + "\n");
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
