package baek4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek4948_Era {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Boolean> plist = new ArrayList<Boolean>();
		
		plist.add(false);
		plist.add(false);
		
		for(int i = 2; i <= 246912; i++) plist.add(i, true);
		
		for(int i = 2; i*i <= 246912; i++) {
			if(plist.get(i)) {
				for(int j = i*i; j <= 246912; j+=i) plist.set(j, false);
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		int count;
		while(n != 0) {
			count = 0;
			for(int i = n+1; i <= 2*n; i++) {
				if(plist.get(i)) count++;
			}
			bw.write(count + "\n");
			n = Integer.parseInt(br.readLine());
		}
		bw.flush();
		bw.close();
	}
}