package baek18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// BOJ 18258 : Queue 2
// using Deque
public class BOJ_18258 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> dq = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			String[] input = br.readLine().split(" ");
			String op = input[0];
			
			switch(op) {
				case "push" : 
					int num = Integer.parseInt(input[1]);
					dq.offer(num);
					break;
			
				case "pop" :
					if(dq.isEmpty()) {
						sb.append(-1 + "\n");
					}
					else sb.append(dq.poll() + "\n");
					break;
				
				case "size" :
					sb.append(dq.size() + "\n");
					break;
				
				case "empty" :
					if(dq.isEmpty()) sb.append(1 + "\n");
					else sb.append(0 + "\n");
					break;
				
				case "front" :
					if(dq.isEmpty()) sb.append(-1 + "\n");
					else sb.append(dq.getFirst() + "\n");
					break;
					
				case "back" :
					if(dq.isEmpty()) sb.append(-1 + "\n");
					else sb.append(dq.getLast() + "\n");
					break;
			}
		}
		
		System.out.print(sb);
	}
}