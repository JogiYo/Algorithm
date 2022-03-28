package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1780 : Number of papers
// Divide and Conquer
public class BOJ_1780 {
    static int minus_one = 0;
    static int zero = 0;
    static int one = 0;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; ++j) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        partition(0, 0 , n);
        sb.append(minus_one + "\n" + zero + "\n" + one);
        System.out.print(sb);
    }

    private static void partition(int row, int col, int size) {
        // number check
        // If compression is possible with the same number, the count of that number is added by 1.
        if(numberCheck(row, col, size)) {
            if(board[row][col] == -1) minus_one++;
            else if(board[row][col] == 0) zero++;
            else one++;
        }
        // if the number is different
        // Recursive call by dividing by 9
        else {
            int interval = size / 3;

            // If you need to compress by splitting, add parentheses and split.
            partition(row, col, interval);
            partition(row, col + interval, interval);
            partition(row, col + (2 * interval), interval);

            partition(row + interval, col, interval);
            partition(row + interval, col + interval, interval);
            partition(row + interval, col + (2 * interval), interval);

            partition(row + (2 * interval), col, interval);
            partition(row + (2 * interval), col + interval, interval);
            partition(row + (2 * interval), col + (2 * interval), interval);
        }
    }

    private static boolean numberCheck(int row, int col, int size) {
        int num = board[row][col];

        for(int i = row; i < row + size; ++i) {
            for(int j = col; j < col +size; ++j) {
                if(board[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
