package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 2606 : Virus
// use DFS or BFS (bfs in this problem)
public class BOJ_2606 {
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

    private static int solution(int[][] matrix) {
        int count = 0;
        boolean[] visit = new boolean[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            int row = queue.poll();

            for(int i = 2; i < matrix[row].length; ++i) {
                if(matrix[row][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
