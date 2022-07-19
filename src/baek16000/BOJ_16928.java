package baek16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 16928 : Snake and Ladder
// use BFS
public class BOJ_16928 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static boolean[] visited = new boolean[101];
    static int[] count = new int[101];
    static int[] snake_ladder = new int[101];
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n,m);
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {
        for(int i = 0; i < n+m; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            snake_ladder[x] = y;
        }

        int answer = bfs();
        sb.append(answer);
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        // starting point is 1
        queue.offer(1);
        count[1] = 0;
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current_idx = queue.poll();
            // Returns the number of dice when reached
            if(current_idx == 100) {
                return count[current_idx];
            }

            // There are six possible numbers when rolling a dice.
            for(int i = 1; i < 7; ++i) {
                int next  = current_idx + i;
                if(next > 100 || visited[next]) continue;

                visited[next] = true;

                // If caught by snakes and ladders
                if(snake_ladder[next] != 0) {
                    if(!visited[snake_ladder[next]]) {
                        queue.offer(snake_ladder[next]);
                        visited[snake_ladder[next]] = true;
                        count[snake_ladder[next]] = count[current_idx] + 1;
                    }
                }
                else {
                    queue.offer(next);
                    count[next] = count[current_idx] + 1;
                }
            }
        }

        return -1;
    }
}