package baek6000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ 6549 : largest rectangle in histogram (Stack.ver)
// use Stack
public class BOJ_6549_Stack {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] histogram;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            histogram = new int[n];

            for(int i = 0; i < n; ++i) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(n)).append("\n");

            histogram = null;
        }
        System.out.print(sb);
    }

    private static long getArea(int length) {
        Stack<Integer> stk = new Stack<>();

        long maxArea = 0;

        for(int i = 0; i < length; ++i) {
            /*
             * When the current histogram height is less than or equal to the height of the previous chain
             * Pop the previous chains smaller than the i-th bar, and find the maximum width.
             */
            while((!stk.isEmpty()) && histogram[stk.peek()] >= histogram[i]) {
                int height = histogram[stk.pop()];

                /*
                 * If there is no previous chain after pop,
                 * The width from the 0th index to the (i-1)th index is unique. (width becomes i)
                 * On the other hand, if the stack is not empty
                 * This means that it contains a chain with a height smaller than the popped height.
                 * The width is obtained by subtracting the index of the next previous chain from the (i-1)th index.
                 */
                long width = stk.isEmpty() ? i : i - 1 - stk.peek();
                maxArea = Math.max(maxArea, height * width);
            }

            /*
             * After the above process,
             * the chains stored in the stack are all less than or equal to i,
             * so the i-th index is pushed.
             */
            stk.push(i);
        }

        /* After the above process is over,
         * the remaining chains in the stack may exist,
         * so the remaining height goes through the same process as above.
         */
        while(!stk.isEmpty()) {
            int height = histogram[stk.pop()];
            long width = stk.isEmpty() ? length : length - 1 - stk.peek();
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}