package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Baek1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		String max = "";
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(!arr.contains(str)) {
				arr.add(str);
			}
		}
		
		Collections.sort(arr);
		
		for(int i = 0; i < arr.size()-1; i++) {
			for(int j = 1; j < arr.size() - i; j++) {
				if(arr.get(j).length() < arr.get(j-1).length()) {
					max = arr.get(j);
					arr.set(j, arr.get(j-1));
					arr.set(j-1, max);
				}
			}
		}
		
		for(int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}