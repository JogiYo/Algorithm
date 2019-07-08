package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1002, Turret problem -> Find the number of intersections of two circles
public class Baek1002 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int x1,y1,r1,x2,y2,r2;
		// d = the distance between the two circles
		double d;
		
		while(tc-- > 0) {
			String[] input = br.readLine().split(" ");
			x1 = Integer.parseInt(input[0]);
			y1 = Integer.parseInt(input[1]);
			r1 = Integer.parseInt(input[2]);
			x2 = Integer.parseInt(input[3]);
			y2 = Integer.parseInt(input[4]);
			r2 = Integer.parseInt(input[5]);
			
			d = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
			// When two circles overlap and the intersection is infinity
			if(x1 == x2 && y1 == y2 && r1 == r2) sb.append("-1\n");
			
			// If there is no intersection
			// 1. When one circle is in another circle and there is no intersection
			// 2. When the distance between two circles is long and there is no intersection
			// 3. When one circle is in another circle but there is no intersection
			else if((x1 == x2 && y1 == y2 && r1 != r2) || (d > r1 + r2) || (d < Math.abs(r1-r2))) {
				sb.append("0\n");
			}
			// If there is one intersection
			// 1. When two outer circles have one intersection
			// 2. When one circle has one intersection in another
			else if((d == r1 + r2) || (Math.abs(r1-r2) == d)) {
				sb.append("1\n");
			}
			// If there is two intersection
			// When two circles overlap and have two intersections
			else sb.append("2\n");
		}
		System.out.print(sb);
	}
}