package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2480 : three dice
// conditional sentence
public class BOJ_2480 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int dice_1 = Integer.parseInt(input[0]);
        int dice_2 = Integer.parseInt(input[1]);
        int dice_3 = Integer.parseInt(input[2]);

        sb.append(solution(dice_1, dice_2, dice_3) + "");

        System.out.print(sb);
    }

    private static int solution(int a, int b, int c) {
        int answer;
        int max = Math.max(a, Math.max(b, c));

        if(a == b) {
            if(b == c) answer = 10000 + a * 1000;
            // a == b
            else answer = 1000 + a * 100;
        }
        else {
            // a == c
            if(a == c) answer = 1000 + a * 100;
            // b == c
            else if(b == c) answer = 1000 + b * 100;
            else answer = max * 100;
        }

        return answer;
    }
}
