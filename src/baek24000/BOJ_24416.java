package baek24000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 24416 : Fibonacci number 1
// use recursion and dynamic programming
public class BOJ_24416 {
    static int[] f = new int[41];
    static int count_1 = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fib(n);
        sb.append(count_1).append(" ").append(fibonacci(n));

        System.out.print(sb);
    }

    private static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;
        int count_2 = 0;
        for(int i = 3; i <= n; ++i) {
            count_2++;
            f[i] = f[i-1] + f[i-2];
        }

        return count_2;
    }

    private static int fib(int n) {
        if(n == 1 || n == 2) {
            count_1++;
            return 1;
        }
        else return fib(n - 1) + fib(n - 2);
    }
}