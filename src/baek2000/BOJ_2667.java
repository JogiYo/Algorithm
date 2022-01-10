package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// BOJ 2667 : apartment complex numbering
// use dfs or bfs
public class BOJ_2667 {
    static int count;
    static int n;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> list;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; ++i) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; ++j) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        solution(matrix);

        sb.append(list.size() + "\n");
        for(int count : list) {
            sb.append(count + "\n");
        }

        System.out.print(sb);
    }

    private static void solution(int[][] matrix) {
        count = 0;
        list = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 1 && !visit[i][j]) {
                    count = 1;
                    dfs(i, j, matrix);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
    }

    private static void dfs(int row, int col, int[][] matrix) {
        visit[row][col] = true;

        for(int i = 0; i < 4; ++i) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if(matrix[nr][nc] == 1 && !visit[nr][nc]) {
                    dfs(nr, nc, matrix);
                    count++;
                }
            }
        }
    }
}