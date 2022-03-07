package baek7000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 7576 : Tomato
// use BFS
public class BOJ_7576 {
    static int[][] map;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Tomato> queue;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[0]);

        map = new int[n][m];
        queue = new LinkedList<>();
        // Add ripe tomatoes to the queue
        for(int i = 0; i < n; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(str[j]);

                if(map[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }

        sb.append(bfs() + "");

        System.out.print(sb);
    }

    private static int bfs() {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int row = tomato.row;
            int col = tomato.col;

            for(int i = 0; i < 4; ++i) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // when raw tomatoes
                    if(map[nx][ny] == 0) {
                        // Tomatoes ripen, put in the queue.
                        queue.add(new Tomato(nx, ny));
                        // Ripe days add 1 to the previous value.
                        map[nx][ny] = map[row][col] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; ++i) {
            for(int  j = 0; j < m; ++j) {
                // If you have unripe tomatoes, not all tomatoes are ripe. return -1
                if(map[i][j] == 0) return -1;

                result = Math.max(result, map[i][j]);
            }
        }
        // Subtract 1 from the result because ripe tomatoes start at 1.
        return result - 1;
    }

    static class Tomato {
        int row;
        int col;

        Tomato(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
