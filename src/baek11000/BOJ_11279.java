package baek11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// BOJ 11279 : Max Heap
// use Priority Queue
public class BOJ_11279 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        solution(N);
        System.out.print(sb);
    }

    private static void solution(int n) throws IOException {
        /*
         * Since the priority queue is in ascending order,
         * sort it in reverse.
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if(queue.isEmpty()) sb.append(0 + "\n");
                else sb.append(queue.poll()).append("\n");
            }
            else queue.offer(num);
        }
    }
}