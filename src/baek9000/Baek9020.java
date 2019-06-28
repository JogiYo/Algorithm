package baek9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek9020 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		int n;
		ArrayList<Boolean> plist = new ArrayList<Boolean>();
		
		plist.add(false);
		plist.add(false);
		
		for(int i = 2; i <= 20000; i++) plist.add(i, true);
		
		for(int i = 2; i*i <= 20000; i++) {
			if(plist.get(i)) {
				for(int j = i*i; j <= 20000; j+=i) plist.set(j, false);
			}
		}
		
		for(int i = 0 ; i < test_case; i++) {
			n = Integer.parseInt(br.readLine());
			int left = 0, right = 0;
			int j = n/2;
			
			if(plist.get(j)) {
				left = j;
				right = j;
			}
			else {
				for(int a = j-1; a > 1; a--) {
					if(plist.get(a)) {
						left = a;
						break;
					}
				}
				for(int b = j+1; b < n; b++) {
					if(plist.get(b)) {
						right = b;
						break;
					}
				}
			}
			
			while(left + right != n) {
				if(left + right > n) {
					for(int a = left-1; a > 1; a--) {
						if(plist.get(a)) {
							left = a;
							break;
						}
					}
				}
				else if(left + right < n) {
					for(int b = right+1; b < n; b++) {
						if(plist.get(b)) {
							right = b;
							break;
						}
					}
				}
			}
			
			bw.write(left + " " + right + "\n");
		}
		bw.flush();
		bw.close();
	}
}