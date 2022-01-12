package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ 1012 : organic cabbage
// use DFS or BFS
public class BOJ_1012 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> list;
    static ArrayList<Integer> result;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        result = new ArrayList<>();

        while(t-- > 0) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int[][] matrix = new int[n][m];

            int k = Integer.parseInt(input[2]);
            while(k-- > 0) {
                String[] point = br.readLine().split(" ");
                int col = Integer.parseInt(point[0]);
                int row = Integer.parseInt(point[1]);
                matrix[row][col] = 1;
            }

            solution(matrix, n, m);
            result.add(list.size());
        }

        for(Integer i : result) {
            sb.append(i + "\n");
        }
        System.out.print(sb);
    }

    private static void solution(int[][] matrix, int n, int m) {
        list = new ArrayList<>();
        visit = new boolean[n][m];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(matrix[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j, matrix, n, m);
                    list.add(0);
                }
            }
        }
    }

    private static void dfs(int row, int col, int[][] matrix, int n, int m) {
        visit[row][col] = true;

        for(int i = 0; i < 4; ++i) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if(matrix[nr][nc] == 1 && !visit[nr][nc]) {
                    dfs(nr, nc, matrix, n, m);
                }
            }
        }
    }
}