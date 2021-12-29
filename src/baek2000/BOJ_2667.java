package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2667 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[input+1][input+1];

        while(n-- > 0) {
            String[] pair = br.readLine().split(" ");
            int row = Integer.parseInt(pair[0]);
            int col = Integer.parseInt(pair[1]);

            matrix[row][col] = matrix[col][row] = 1;
        }

        bw.write(String.valueOf(solution(matrix)));
        bw.flush();

        bw.close();
        br.close();
    }
}
