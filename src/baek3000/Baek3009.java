package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ3009, Given three points, find the fourth point needed to create a rectangle parallel to the axis
public class Baek3009 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] x = new int[3];
		int[] y = new int[3];
		int ans_x;
		int ans_y;
		
		for(int i = 0; i < 3; i++) {
			String[] input = br.readLine().split(" ");
			x[i] = Integer.parseInt(input[0]);
			y[i] = Integer.parseInt(input[1]);
		}
		
		// The process of finding x once appeared
		if(x[0] == x[1]) ans_x = x[2];
		else if(x[0] == x[2]) ans_x = x[1];
		else ans_x = x[0];
		// The process of finding y once appeared
		if(y[0] == y[1]) ans_y = y[2];
		else if(y[0] == y[2]) ans_y = y[1];
		else ans_y = y[0];
		
		sb.append(ans_x + " " + ans_y);
		System.out.print(sb);
	}
}