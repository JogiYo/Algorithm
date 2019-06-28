package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ������ ����
// https://appree.tistory.com/7 ����
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
		// ���� +,-�θ� �����̴� ���(��� 1)
		int answer = (int)Math.abs(N - start_ch);
		
		// ���̰� ���� ���� ���ڸ� ���ϰ�(�� ���� ���̰� ������ Ƚ��),�� �� ���̸�ŭ +,-�ϴ� ��� (��� 2)
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
	// brute force (���� Ž��) �� ä���� ����(������ Ƚ��)�� ����, ���峭�� ���� ��� 0
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