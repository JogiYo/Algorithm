package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 10773 : Zero
// using stack
public class BOJ_10773 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(br.readLine());		
		Stack<Integer> stk = new Stack<>();
		int sum = 0;
		
		while(k-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) stk.pop();
			else stk.push(num);
		}
		
		if(!stk.isEmpty()) {
			while(!stk.isEmpty()) {
				sum += stk.pop();
			}
		}
		
		sb.append(sum + "");
		System.out.print(sb);
	}
}