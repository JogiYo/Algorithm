package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2563 : Confetti
public class BOJ_2563 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] confetti = new int[n][2];

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            confetti[i][0] = Integer.parseInt(st.nextToken());
            confetti[i][1] = Integer.parseInt(st.nextToken());
        }
        sb.append(solution(confetti));
        System.out.print(sb);
    }

    private static int solution(int[][] confetti) {
        int answer = 0;
        boolean[][] area = new boolean[101][101];

        for (int[] point : confetti) {
            int row = point[0];
            int col = point[1];

            for(int x = row; x < row + 10; ++x) {
                for(int y = col; y < col + 10; ++y) {
                    area[x][y] = true;
                }
            }
        }

        for (boolean[] areas : area) {
            for (int j = 0; j < area[0].length; ++j) {
                if (areas[j]) answer++;
            }
        }

        return answer;
    }
}