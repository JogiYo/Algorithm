package baek4000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 4949 : A balanced world
// using stack
public class BOJ_4949 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		
		while(true) {
			String str = br.readLine();
			boolean flag = true;
			if(str.equals(".")) break;
			
			for(int i = 0; i < str.length(); ++i) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[') {
					stk.push(str.charAt(i));
				}
				else if(str.charAt(i) == ')') {
					if(stk.isEmpty() || stk.peek() == '[') {
						flag = false;
						break;
					}
					else if(stk.peek() == '(') {
						stk.pop();
					}
				}
				else if(str.charAt(i) == ']') {
					if(stk.isEmpty() || stk.peek() == '(') {
						flag = false;
						break;
					}
					else if(stk.peek() == '[') {
						stk.pop();
					}
				}
			}
			
			if(flag && stk.isEmpty()) sb.append("yes\n");
			else sb.append("no\n");
			stk.clear();
		}
		
		System.out.print(sb);
	}
}