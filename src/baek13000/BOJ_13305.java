package baek13000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 13305 : Gas Station
// Greedy Algorithm
public class BOJ_13305 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N-1; ++i) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        sb.append(solution(dist, cost));
        System.out.print(sb);
    }

    private static long solution(long[] dist, long[] cost) {
        long sum = 0;
        long min_cost = cost[0];

        /*
         * Refuel when cost is in descending order.
         * cost {5, 2, 4, 1} => {5, 2, 2, 1}
         */
        for(int i = 0; i < dist.length; ++i) {
            if(cost[i] < min_cost)  min_cost = cost[i];

            sum += (min_cost * dist[i]);
        }

        return sum;
    }
}