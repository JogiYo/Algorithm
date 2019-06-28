package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1057 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int total = Integer.parseInt(input[0]);
		int kim = Integer.parseInt(input[1]);
		int lim = Integer.parseInt(input[2]);
		int round = 1;
		boolean flag = false;
		
		while(true) {
			if((kim + 1) /2 == (lim + 1) /2) {
				flag = true;
				break;
			}
			if(total % 2 == 1) total += 1;
			total /= 2;
			kim = (kim + 1) /2;
			lim = (lim + 1) /2;
			round++;
			if(total == 1) sb.append(-1);
		}
		
		if(flag) sb.append(round);
		System.out.print(sb);
	}
}