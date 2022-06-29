package baek11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// BOJ 11286 : Absolute value heap
// use Priority Queue
public class BOJ_11286 {
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
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            /*
             *  If o1 is greater than o2 based on the absolute value, the place is swapped.
             */
            if(Math.abs(o1) > Math.abs(o2)) return 1;
            /*
             *  If the two values are equal in absolute value, a negative number is sent forward.
             */
            else if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return -1;
        });

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