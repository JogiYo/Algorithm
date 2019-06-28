package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2455 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int human_count = 0;
		int max = 0;
		int station = 4;
		while(station-- > 0) {
			String[] input = br.readLine().split(" ");
			int out = Integer.parseInt(input[0]);
			int in = Integer.parseInt(input[1]);
			human_count = human_count + in - out;
			if(human_count > max) max = human_count;
		}
		sb.append(max);
		System.out.println(sb);
	}
}