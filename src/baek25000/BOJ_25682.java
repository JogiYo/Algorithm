package baek25000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 25682 : Repaint the chessboard 2
// use Cumulative Sum and Segment Sum
public class BOJ_25682 {
    static BufferedReader br;
    static StringBuilder sb;

    static int n, m, k;
    static char[][] chess;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chess = new char[n][m];
        String line;
        for(int i = 0; i < n; ++i) {
            line = br.readLine();
            for(int j = 0; j < m; ++j) chess[i][j] = line.charAt(j);
        }

        /*
         * Since it depends on whether the first tile on the chessboard is black or white,
         * we compare the two cases.
         */
        sb.append(Math.min(solution('B'), solution('W')));
        System.out.print(sb);
    }

    private static int solution(char color) {
        int count = Integer.MAX_VALUE;
        int sameColor;
        int[][] prefixSum = new int[n+1][m+1];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                /*
                 * If the sum of rows and columns is even, the color is the same
                 * if the sum of the columns is odd, the color is different.
                 * 1 if the colors are different, 0 if they are the same.
                 */
                if((i+j)%2 == 0) {
                    sameColor = chess[i][j] != color ? 1 : 0;
                }
                else {
                    sameColor = chess[i][j] == color ? 1 : 0;
                }

                // Because prefixSum[i][j] is duplicated, it is subtracted once.
                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + sameColor;
            }
        }

        for(int i = 1; i <= n-k+1; ++i) {
            for(int j = 1; j <= m-k+1; ++j) {
                // Calculates the sum of segments in a region.
                // the same way as 1 2 3 4 5 -> sum of segments(3~5) : 5 - 2 = 3
                count = Math.min(count,
                            prefixSum[i+k-1][j+k-1]
                                    - prefixSum[i+k-1][j-1]
                                    - prefixSum[i-1][j+k-1]
                                    + prefixSum[i-1][j-1]);
            }
        }

        return count;
    }
}