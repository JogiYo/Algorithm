package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baek9375 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> dress = new HashMap<String, Integer>();
			for(int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				if(dress.containsKey(str[1])) {
					dress.put(str[1], dress.get(str[1]) + 1);
				}
				else {
					dress.put(str[1], 1);
				}
			}
			int result = 1;
			
			for(int i : dress.values()) {
				result *= i + 1;
			}
			
			result -= 1;
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
	}
}