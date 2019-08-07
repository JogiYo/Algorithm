package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ1436, Brute force
// the problem of trying in turn until the number of N's endings is reached
public class BOJ1436 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int i = 666;
		int count = 0;
		int temp = 0;
		
		// brute force, Check to see if 666 is included
		// At first, I tried to include strings, but this method used a lot of time and memory
		// So I compared it with numbers to determine whether it should be included.
		while(true) {
			temp = i;
			while(temp >= 666) {
				if(temp % 10 == 6 && (temp/10) % 10 == 6 && (temp/100) % 10 == 6) {
					count++;
					break;
				}
				temp /= 10;
			}
			if(count == n) {
				sb.append(i+"");
				break;
			}
			i++;
		}
		System.out.print(sb);
	}
}