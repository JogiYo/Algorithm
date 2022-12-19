package baek17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ 17299 : The number that is located on the right and has a large number of appearances
// use Stack
public class BOJ_17299 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(n, arr);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        Stack<Integer> stk = new Stack<>();

        int[] count = new int[1000001];
        for(int i = 0; i < n; ++i) {
            count[arr[i]]++;
        }

        /*
         * ex) A : 1 1 2 3 4 2 1 -> count : 3 3 2 1 1 2 3
         * i = 5, stk : 4 3 2 1 0
         * count[a[5] = 2] = 2 > count[4] = 1
         * answer[4] = 2, stk : 3 2 1 0
         * count[2] = 2 > count[3] = 1
         * answer[3] = 2, stk : 2 1 0
         */
        for(int i = 0; i < n; ++i) {
            while(!stk.isEmpty() && count[arr[i]] > count[arr[stk.peek()]]) {
                answer[stk.pop()] = arr[i];
            }
            stk.push(i);
        }

        // The number that satisfies the condition cannot be found in the index remaining on the stack.
        while(!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        return answer;
    }
}