package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			Stack<String> stk = new Stack<String>();
			String[] str = br.readLine().split("");		
			boolean flag = true;
			
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals("(")) {
					stk.push(str[i]);
				}
				else {
					if(stk.isEmpty()) {
						flag = false;
						break;
					}
					else stk.pop();
				}
			}
			if(!stk.isEmpty()) flag = false;
			
			if(flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);
	}
}