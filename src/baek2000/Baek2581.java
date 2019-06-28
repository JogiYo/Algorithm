package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek2581 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i = m; i <=n; i++) {
			if(i != 1) {
				boolean flag = false;
				for(int j = 2; j < i; j++) {
					if(i%j == 0) {
						flag = true;
						break;
					}
				}
				if(!flag) arr.add(i);
			}
		}
		
		if(arr.isEmpty()) {
			bw.write(-1 + "");
		}
		else {
			for(int i = 0; i < arr.size(); i++) {
				sum += arr.get(i);
			}
			
			bw.write(sum +"\n" + arr.get(0));
		}
		bw.flush();
		bw.close();
	}
}