package baek15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BOJ 15828 : Router
// use Queue
public class BOJ_15828 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        solution(n);
        System.out.print(sb);
    }

    private static void solution(int n) throws IOException {
        Queue<Integer> router = new LinkedList<>();

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == -1) break;

            if(num == 0) router.poll();
            else if(router.size() < n) {
                router.offer(num);
            }
        }

        if(router.isEmpty()) sb.append("empty");
        else {
            sb.append(router.poll());
            while(!router.isEmpty()) {
                sb.append(" ").append(router.poll());
            }
        }
    }
}