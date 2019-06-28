package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Baek1021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> dq = new LinkedList<Integer>();
		int result = 0;
		
		String[] input_count = br.readLine().split(" ");
		String[] input_atom = br.readLine().split(" ");
		
		int n = Integer.parseInt(input_count[0]);
		int m = Integer.parseInt(input_count[1]);
		
		for(int i = 1; i <= n; i++) {
			dq.offer(i);
		}
		
		for(int i = 0; i < m; i++) {
			int target = Integer.parseInt(input_atom[i]);
			if(dq.peek() == target) {
				dq.poll();
			}
			else {
				int count = 0;
				while(target != dq.peek()) {
					dq.offerLast(dq.poll());
					count++;
				}
				
				if(count > dq.size()/2) {
					while(count-- > 0) {
						dq.offerFirst(dq.pollLast());
					}
					count = 0;
					while(target != dq.peek()) {
						dq.offerFirst(dq.pollLast());
						count++;
					}
				}
				
				dq.poll();
				result += count;
			}
		}	
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}