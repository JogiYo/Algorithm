package baek7000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 7569 : Tomato
// use BFS
public class BOJ_7569 {
    static int[][][] map;
    static int n;
    static int m;
    static  int h;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Tomato> queue;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[2]);

        map = new int[n][m][h];
        queue = new LinkedList<>();
        // Add ripe tomatoes to the queue
        for(int i = 0; i < n*h; ++i) {
            String[] str = br.readLine().split(" ");
            int r;
            int k = i / n;

            if(i < n) r = i;
            else r = i % n;

            for(int j = 0; j < m; ++j) {
                map[r][j][k] = Integer.parseInt(str[j]);

                if(map[r][j][k] == 1) {
                    queue.add(new Tomato(r, j, k));
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
            int height = tomato.height;

            for(int i = 0; i < 6; ++i) {
                int nx = row + dx[i];
                int ny = col + dy[i];
                int nz = height + dz[i];

                if(nx >= 0 && ny >= 0 &&  nz >= 0 && nx < n && ny < m && nz < h) {
                    // when raw tomatoes
                    if(map[nx][ny][nz] == 0) {
                        // Tomatoes ripen, put in the queue.
                        queue.add(new Tomato(nx, ny, nz));
                        // Ripe days add 1 to the previous value.
                        map[nx][ny][nz] = map[row][col][height] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; ++i) {
            for(int  j = 0; j < m; ++j) {
                for(int k = 0; k < h; ++k) {
                    // If you have unripe tomatoes, not all tomatoes are ripe. return -1
                    if(map[i][j][k] == 0) return -1;

                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
        // Subtract 1 from the result because ripe tomatoes start at 1.
        return result - 1;
    }

    static class Tomato {
        int row;
        int col;
        int height;

        Tomato(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
