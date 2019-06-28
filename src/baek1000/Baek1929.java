package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		ArrayList<Boolean> plist = new ArrayList<Boolean>(n+1);
		
		plist.add(false);
		plist.add(false);
		
		for(int i = 2; i <= n; i++) plist.add(i, true);
		
		for(int i = 2; i*i <= n; i++) {
			if(plist.get(i)) {
				for(int j = i*i; j <= n; j+=i) plist.set(j, false);
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(plist.get(i)) bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
}