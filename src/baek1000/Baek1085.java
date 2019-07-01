package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ1085, The problem of finding the minimum value of the distance to the boundary of a rectangle.
// (x, y) are given. 
// The lower left corner of the rectangle is at (0, 0), 
// and the upper right corner is at (w, h).
public class Baek1085 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);
		
		int[] dist = new int[4];
		dist[0] = x;
		dist[1] = y;
		dist[2] = w-x;
		dist[3] = h-y;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < 4; i++) {
			if(dist[i] < min) min = dist[i];
		}
		
		sb.append(min);
		System.out.print(sb);
	}
}