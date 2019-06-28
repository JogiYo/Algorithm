package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// Knuth's optimization(ũ���� ����ȭ)
// https://js1jj2sk3.tistory.com/3
// https://sexycoder.tistory.com/92
public class Baek11066 {
	static int[][] dp = new int[501][501];
	static int[] novel = new int[501];
	static int[] psum = new int[501];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			int chapter = Integer.parseInt(br.readLine());
			String[] c_size = br.readLine().split(" ");
			
			// novel �迭���� ������ �� ���� ������ ũ�⸦ �ְ�
	        // sum �迭���� �� ����ũ����� �������� ����ؼ� �ִ´�.
			for(int i = 1; i <= chapter; i++) {
				novel[i] = Integer.parseInt(c_size[i-1]);
				psum[i] = psum[i-1] + novel[i];
			}
			
			// 1��° ����� ������ ���� chapter �ٷ� �������� �ݺ��Ѵ�.
			for(int i = 1; i < chapter; i++) {
				for(int x = 1; x + i <= chapter; x++) {
					int y = x + i;
					dp[x][y] = Integer.MAX_VALUE;
					
					for(int k = x; k < y; k++) {
						dp[x][y] = Math.min(dp[x][y], dp[x][k] + dp[k + 1][y] + psum[y] - psum[x - 1]);
					}
				}
			}
			sb.append(dp[1][chapter] + "\n");
		}
		System.out.print(sb);
	}
}