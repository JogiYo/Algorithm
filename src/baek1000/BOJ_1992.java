package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1992 : Quad Tree (Converting a quadtree to a string)
// use divide and conquer
public class BOJ_1992 {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; ++i) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; ++j) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        partition(0, 0 , n);
        System.out.print(sb);
    }

    private static void partition(int row, int col, int size) {
        // number check
        // If compression is possible, add the corresponding number.
        if(numberCheck(row, col, size)) {
            sb.append(board[row][col]);
        }
        // if the number is different
        // Recursive call by dividing by 4
        else {
            int half = size / 2;

            // If you need to compress by splitting, add parentheses and split.
            sb.append("(");
            partition(row, col, half);
            partition(row, col + half, half);
            partition(row + half, col, half);
            partition(row + half, col + half, half);
            sb.append(")");
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
