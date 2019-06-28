package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek2504 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stk = new Stack<>();
		String[] str = br.readLine().split("");
		int result = 0;
		
		stk.push(str[0]);
		for(int i = 1; i < str.length; i++) {
			if(str[i].equals("(") || str[i].equals("[")) {
				stk.push(str[i]);
			}
			
			// ')'가 왔을 경우
			else if(str[i].equals(")")) {
				if(stk.peek().equals("(")) {
					stk.pop();
					stk.push("2");
				}
				else {
					int temp = 0;
					while(!stk.isEmpty()) {
						String top = stk.pop();
						if(top.equals(")") || top.equals("[") || top.equals("]")) {
							System.out.println(0);
							return;
						}
						if(top.equals("(")) {
							stk.push(2*temp+"");
							break;
						}
						temp += Integer.parseInt(top);
					}
					if(stk.isEmpty()) {
						System.out.println(0);
						return;
					}
				}
			}
			
			// ']'가 왔을 경우
			else if(str[i].equals("]")) {
				if(stk.peek().equals("[")) {
					stk.pop();
					stk.push("3");
				}
				else {
					int temp = 0;
					while(!stk.isEmpty()) {
						String top = stk.pop();
						if(top.equals("]") || top.equals("(") || top.equals(")")) {
							System.out.println(0);
							return;
						}
						if(top.equals("[")) {
							stk.push(3*temp+"");
							break;
						}
						temp += Integer.parseInt(top);
					}
					if(stk.isEmpty()) {
						System.out.println(0);
						return;
					}
				}
			}
			
			else {
				System.out.println(0);
				return;
			}
		}
		
		while(!stk.isEmpty()) {
			if(stk.peek().equals("(") || stk.peek().equals(")") || stk.peek().equals("[") || stk.peek().equals("]")) {
				System.out.println(0);
				return;
			}
			result += Integer.parseInt(stk.pop());
		}
		System.out.println(result);
	}
}