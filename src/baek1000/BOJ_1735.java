package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1735 : Sum of fractions
// Find the sum of fractions and the greatest common divisor of the numerator and denominator.
public class BOJ_1735 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int[][] arr = new int[2][2];
        for(int i = 0; i < 2; ++i) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr);
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }

    private static int[] solution(int[][] arr) {
        int numerator = (arr[0][0]*arr[1][1]) + (arr[0][1]*arr[1][0]);
        int denominator = arr[0][1]*arr[1][1];

        int gcd_num = gcd(numerator, denominator);

        numerator /= gcd_num;
        denominator /= gcd_num;

        return new int[] {numerator, denominator};
    }

    private static int gcd(int num1, int num2) {
        if(num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}