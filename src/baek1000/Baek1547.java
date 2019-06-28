package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1547 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int change_count = Integer.parseInt(br.readLine());
		boolean[] ball = new boolean[4];
		ball[1] = true;
		
		while(change_count-- > 0) {
			String[] input = br.readLine().split(" ");
			int first = Integer.parseInt(input[0]);
			int second = Integer.parseInt(input[1]);
			
			if(ball[first] || ball[second]) {
				ball[first] = !ball[first];
				ball[second] = !ball[second];
			}
		}
		
		for(int i = 1; i < 4; i++) {
			if(ball[i]) {
				sb.append(i);
				System.out.print(sb);
				break;
			}
		}
	}
}