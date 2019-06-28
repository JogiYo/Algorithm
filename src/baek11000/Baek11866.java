package baek11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baek11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		int count = 1;
		bw.write("<");
		while(queue.size() != 1) {
			if(count == k) {
				count = 1;
				bw.write(queue.poll() + ", ");
			}
			else {
				count++;
				queue.offer(queue.poll());
			}
		}
		bw.write(queue.poll() + ">");
		bw.flush();
		bw.close();
	}
}