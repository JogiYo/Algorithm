package baek24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ 24479 : Depth First Search 1
// use DFS, adjacency list
public class BOJ_24479 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    static int[] answer;
    static int order = 0;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        solution(N, M, R);
        System.out.print(sb);
    }

    private static void solution(int n, int m, int r) throws IOException {
        answer = new int[n+1];
        edges = new ArrayList[n+1];
        visited = new boolean[n+1];
        int order = 0; // node visit order

        for(int i = 1; i <= n; ++i) {
            edges[i] = new ArrayList<>();
        }

        /*
         *  Implemented as an adjacency list.
         *  because of ascending
         */
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        // Sort the adjacency list of each vertex in ascending order.
        for(int i = 1; i <= n; ++i) Collections.sort(edges[i]);

        visited[r] = true;
        dfs(r);

        for(int i = 1; i <= n; ++i) sb.append(answer[i]).append("\n");
    }

    private static void dfs(int cur) {
        answer[cur] = ++order;
        for(int next : edges[cur]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}