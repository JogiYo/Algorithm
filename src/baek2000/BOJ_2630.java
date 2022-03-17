package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2630 : Make confetti
// use divide and conquer
public class BOJ_2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; ++j) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        partition(0, 0 , n);

        sb.append(white + "\n" + blue);
        System.out.print(sb);
    }

    private static void partition(int row, int col, int size) {
        // color check
        // If all partitions are the same color
        if(colorCheck(row, col, size)) {
            if(board[row][col] == 0) white++;
            else blue++;
        }
        // if the color is different
        // Recursive call by dividing by 4
        else {
            int half = size / 2;
            partition(row, col, half);
            partition(row + half, col, half);
            partition(row, col + half, half);
            partition(row + half, col + half, half);
        }
    }

    private static boolean colorCheck(int row, int col, int size) {
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
