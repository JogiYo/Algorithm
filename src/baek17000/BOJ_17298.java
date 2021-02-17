package baek17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 17298 : NGE
// using stack, The point is to put the index on the stack
public class BOJ_17298 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stk = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		int[] ans = new int[n];
		
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(input[i]);
		}
		// Save the first index
		stk.push(0);
		for(int i = 1; i < n; ++i) {
			// If it is not empty and
			// the number is greater than the number at the top of the index
			while(!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
				ans[stk.pop()] = arr[i];
			}
			// push the next index
			stk.push(i);
		}
		// After the loop is finished, 
		// the indexes remaining on the stack do not satisfy the condition, 
		// so the value is mapped to -1.
		while(!stk.isEmpty()) {
			ans[stk.pop()] = -1;
		}
		
		sb.append(ans[0]);
		for(int i = 1; i < n; ++i) {
			sb.append(" " + ans[i]);
		}
		System.out.print(sb);
	}
}