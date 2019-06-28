package baek5000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			Deque<Integer> dq = new LinkedList<Integer>();
			sb.delete(0, sb.length());
			String[] op = br.readLine().split("");
			int arr_count = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split("");
			
			String num = "";
			for(int i = 1; i < arr.length-1; i++) {
				if(arr[i].charAt(0) >= 48 && arr[i].charAt(0) < 58) {
					num = num + arr[i];
					
					if(arr[i+1].charAt(0) < 48 || arr[i+1].charAt(0) >= 58) {
						dq.offer(Integer.parseInt(num));
						num = "";
					}
				}
			}
			
			boolean reverse_flag = true;   // true면 순방향 false면 역방향
			boolean error_flag = false;
			
			for(int i = 0; i < op.length; i++) {
				if(op[i].equals("R")) {
					reverse_flag = !reverse_flag;
				}
				else if(op[i].equals("D")) {
					if(dq.isEmpty()) {
						sb.delete(0, sb.length());
						sb.append("error");
						error_flag = true;
						break;
					}
					else {
						if(reverse_flag) {
							dq.pollFirst();
						}
						else {
							dq.pollLast();
						}
					}
				}
			}
			
			if(!error_flag) sb.append("[");
			while(!dq.isEmpty() && dq.size() != 1) {
				if(reverse_flag) {
					sb.append(dq.pollFirst() + ",");
				}
				else {
					sb.append(dq.pollLast() + ",");
				}
			}
			if(!dq.isEmpty()) sb.append(dq.poll());
			if(!error_flag) sb.append("]");
			
			result.append(sb + "\n");
		}
		
		System.out.println(result);
	}
}