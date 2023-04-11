package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 11005 : Base conversion 2
// use ASCII Code
public class BOJ_11005 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[2];
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());

        String result = solution(input);
        sb.append(result);
        System.out.print(sb);
    }

    private static String solution(int[] input) {
        int decimalNum = input[0];
        int convNum = input[1];

        String result = "";
        while(decimalNum > 0) {
            int quotient = decimalNum / convNum;
            int remainder = decimalNum % convNum;

            // ASCII Code
            char ch;
            if(0 <= remainder && remainder <= 9) {
                // 0 - 9
                ch = (char)(remainder + 48);
            }
            else {
                // A - Z
                ch = (char)(remainder + 55);
            }

            result = ch + result;
            decimalNum = quotient;
        }

        return result;
    }
}