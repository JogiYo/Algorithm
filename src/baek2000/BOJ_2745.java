package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2745 : Base conversion 1
// use ASCII Code
public class BOJ_2745 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] input = new String[2];
        input[0] = st.nextToken();
        input[1] = st.nextToken();

        int result = solution(input);
        sb.append(result);
        System.out.print(sb);
    }

    private static int solution(String[] input) {
        String num = input[0];
        int convNum = Integer.parseInt(input[1]);

        int power = 0;
        int result = 0;
        for(int i = num.length()-1; i >= 0; i--) {
            // use ASCII Code
            int number;
            // A - Z
            if(num.charAt(i) >= 65) number = num.charAt(i) - 55;
            // 0 - 9
            else number = num.charAt(i) - 48;

            result += Math.pow(convNum, power) * number;
            power++;
        }

        return result;
    }
}