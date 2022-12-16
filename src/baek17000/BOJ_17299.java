package baek17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

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

        System.out.print(sb);
    }

    private static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        Stack<Integer> stk = new Stack<>();

        int[] count = new int[1000001];
        for(int i = 0; i < n; ++i) {
            count[arr[i]]++;
        }

        for(int i = 0; i < n; ++i) {
            while(!stk.isEmpty() && count[arr[i]] > count[arr[stk.peek()]]) {
                answer[stk.pop()] = arr[i];
            }
            stk.push(i);
        }

        while(!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        return answer;
    }
}