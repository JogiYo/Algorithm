package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ 1697 : Hide and seek
// use BFS
public class BOJ_1697 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        solution(N, K);
        System.out.print(sb);
    }

    private static void solution(int n, int k) {
        int answer = bfs(n, k);
        sb.append(answer);
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int current_idx;
        visited[n] = 1;

        while(!queue.isEmpty()) {
            current_idx = queue.poll();

            // When you reach your brother's position
            if(current_idx == k) {
                // When it is 0 seconds, it is treated as -1
                // because the start of the initial location visit is set to 1.
                return visited[current_idx] - 1;
            }

            // If the position is x-1 and if the location is not visited
            if(current_idx - 1 >= 0 && visited[current_idx - 1] == 0) {
                visited[current_idx - 1] = visited[current_idx] + 1;
                queue.offer(current_idx - 1);
            }

            // If the position is x+1 and if the location is not visited
            if(current_idx + 1 <= 100000 && visited[current_idx + 1] == 0) {
                visited[current_idx + 1] = visited[current_idx] + 1;
                queue.offer(current_idx + 1);
            }

            // If the position is 2*x and if the location is not visited
            if(current_idx * 2  <= 100000 && visited[current_idx * 2] == 0) {
                visited[current_idx * 2] = visited[current_idx] + 1;
                queue.offer(current_idx * 2);
            }
        }

        return -1;
    }
}