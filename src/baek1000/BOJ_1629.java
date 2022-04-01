package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 1629 : Multiplication (power)
// Divide and Conquer
public class BOJ_1629 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        
        sb.append(solution(a,b,c) + "");

        System.out.print(sb);
    }

    private static long solution(int base, int exponent, int c) {
        if(exponent == 1) return base % c;

        int half_exp = exponent/2;
        long num = solution(base, half_exp, c);
        long result = (num * num) % c;

        // If the exponent is odd
        if(exponent % 2 == 1) result = (result * base) % c;

        return result;
    }
}
