package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// BOJ 1655 : Say the middle
// use Priority Queue
public class BOJ_1655 {
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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            // Both queues must be filled for swap.
            /*
             * ex)
             * maxheap[5 , 6]  minheap [10]   <- input 4
             * maxheap[5 , 6]  minheap [4, 10]  <- 6 > 4  : swap
             * maxheap[4 , 5]  minheap [6, 10]
             */
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }
    }
}