package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 2178 : maze exploration
// use BFS
public class BOJ_2178 {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];

        for(int i = 0; i < n; ++i) {
            String s = br.readLine();
            for(int j = 0; j < m; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);

        sb.append(map[n-1][m-1] + "");

        System.out.print(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int px = now[0];
            int py = now[1];

            for(int i = 0; i < 4; ++i) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0 || visited[nx][ny]) continue;

                queue.add(new int[] {nx, ny});
                map[nx][ny] = map[px][py] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}
