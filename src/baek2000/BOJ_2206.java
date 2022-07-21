package baek2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static class Location {
        int row, col, distance, destroy;

        public Location(int row, int col, int distance, int destroy) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.destroy = destroy;
        }
    }
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int N, M;
    static int[][] map, visited;

    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        solution(N,M);
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {
        for(int i = 0; i < N; ++i) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        sb.append(bfs(0,0));
    }

    private static int bfs(int row, int col) {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(row, col, 1, 0));
        visited[row][col] = 0;

        while(!queue.isEmpty()) {
            Location location = queue.poll();

            if(location.row == N-1 && location.col == M-1) {
                return location.distance;
            }

            for(int i = 0; i < 4; ++i) {
                int nrow = location.row + drow[i];
                int ncol = location.col + dcol[i];

                if(nrow < 0 || ncol < 0 || nrow  >= N || ncol >= M) continue;

                if(visited[nrow][ncol] <= location.destroy) continue;

                if(map[nrow][ncol] == 0) {
                    visited[nrow][ncol] = location.destroy;
                    queue.offer(new Location(nrow, ncol, location.distance+1, location.destroy));
                }
                else {
                    if(location.destroy == 0) {
                        visited[nrow][ncol] = location.destroy + 1;
                        queue.offer(new Location(nrow, ncol, location.distance+1, location.destroy+1));
                    }
                }
            }
        }

        return -1;
    }
}