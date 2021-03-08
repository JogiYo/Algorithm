package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 2164 : Card 2
// using queue
public class BOJ_2164 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> qu = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; ++i) {
			qu.offer(i);
		}
		
		while(qu.size() > 1) {
			qu.poll();
			qu.offer(qu.poll());
		}
		
		sb.append(qu.poll() + "");
		System.out.print(sb);
	}
}