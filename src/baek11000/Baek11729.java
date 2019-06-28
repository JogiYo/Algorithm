package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ11729, solve hanoi problem using recursion
public class Baek11729 {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n,1,3);
		System.out.println(count);
		System.out.print(sb);
	}
	private static void hanoi(int n, int x, int y) {
		int z = 6-x-y;
		if(n <= 1) {
			count++;
			sb.append(x + " " + y + "\n");
		}
		else {
			// Move the n-1 plates to the remaining columns, not the target.
			hanoi(n-1,x,z);
			// Move the bottom plate to the target i want to move.
			count++;
			// Move the plates from the remaining columns to the target.
			sb.append(x + " " + y + "\n");
			hanoi(n-1,z,y);
		}
	}
}