package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 2587 : Representative value
public class BOJ_2587 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int[] num = new int[5];

        for(int i = 0; i < num.length; ++i) {
            num[i] = Integer.parseInt(br.readLine());
        }

        solution(num);
        System.out.print(sb);
    }

    private static void solution(int[] num) {
        int sum = 0;

        Arrays.sort(num);
        for (int number : num) {
            sum += number;
        }

        sb.append(sum / 5).append("\n").append(num[2]);
    }
}