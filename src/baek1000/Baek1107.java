package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 리모컨 문제
// https://appree.tistory.com/7 참고
public class Baek1107 {
	static boolean[] broken_button = new boolean[10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int start_ch = 100;
		int N = Integer.parseInt(br.readLine());
		
		int broken_num = Integer.parseInt(br.readLine());
		
		if(broken_num != 0) {
			String[] bb = br.readLine().split(" ");
			for(int i = 0; i < broken_num; i++) {
				broken_button[Integer.parseInt(bb[i])] = true;
			}
		}
		// 오직 +,-로만 움직이는 경우(경우 1)
		int answer = (int)Math.abs(N - start_ch);
		
		// 차이가 가장 작은 숫자를 구하고(이 수의 길이가 누르는 횟수),그 후 차이만큼 +,-하는 경우 (경우 2)
		for(int i = 0; i <= 1000000; i++) {
			int channel = i;
			int length = canMove(channel);
			if(length > 0) {
				int press = (int)Math.abs(channel - N);
				if(answer > length + press) {
					answer = length + press;
				}
			}
		}
		sb.append(answer);
		System.out.println(sb);
		
	}
	// brute force (완전 탐색) 한 채널의 길이(누르는 횟수)를 구함, 고장난게 있을 경우 0
	public static int canMove(int channel) {
		int length = 0;
		
		if(channel == 0) {
			return broken_button[0] ? 0 : 1;
		}
		
		while(channel > 0) {
			if(broken_button[channel % 10]) {
				return 0;
			}
			length += 1;
			channel /= 10;
		}
		return length;
	}
}