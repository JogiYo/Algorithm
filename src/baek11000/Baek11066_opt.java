package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 최적화를 적용하기 전에는 O(n^3)의 복잡도를 가지지만 최적화 후에는 O(n^2)의 복잡도를 가진다.
// BOJ 기준 최적화 전 504ms 최적화 후 176ms
// https://sexycoder.tistory.com/92 에서 설명과 함께 다시 공부할 것
public class Baek11066_opt {
	static int[][] dp = new int[501][501];
	static int[] novel = new int[501];
	static int[] C = new int[501];
	static int[][] A = new int[501][501];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			int chapter = Integer.parseInt(br.readLine());
			String[] c_size = br.readLine().split(" ");
			
			// novel 배열에는 파일의 각 장이 가지는 크기를 넣고
	        // sum 배열에는 그 파일크기들의 누적합을 계산해서 넣는다.
			for(int i = 1; i <= chapter; i++) {
				novel[i] = Integer.parseInt(c_size[i-1]);
				C[i] = C[i-1] + novel[i];
			}
			
			for(int i = 1; i <= chapter; i++) {
				A[i-1][i] = i;
			}
			
			// 1번째 장부터 마지막 장인 chapter 바로 직전까지 반복한다.
			for(int i = 2; i <= chapter; i++) {
				for(int x = 0; x + i <= chapter; x++) {
					int y = x + i;
					dp[x][y] = Integer.MAX_VALUE;
					
					for(int k = A[x][y-1]; k <= A[x+1][y]; k++) {
						int min = dp[x][k] + dp[k][y] + C[y] - C[x];
						
						if(dp[x][y] > min) {
							dp[x][y] = min;
							A[x][y] = k;
						}
					}
				}
			}
			sb.append(dp[0][chapter] + "\n");
		}
		System.out.print(sb);
	}
}