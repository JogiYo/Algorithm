package baek24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ 24444 : Breadth First Search 1
// use BFS, adjacency list
public class BOJ_24444 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    static int[] answer;
    static int order = 0; // node visit order
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

        bfs(r);

        for(int i = 1; i <= n; ++i) sb.append(answer[i]).append("\n");
    }

    private static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            answer[num] = ++order;

            for(int next : edges[num]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}