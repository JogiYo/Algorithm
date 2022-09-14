package baek25000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 25501 : Master of recursion
// Let's understand how a function call of a recursive function is made.
public class BOJ_25501 {
    static BufferedReader br;
    static StringBuilder sb;
    static int call_count;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String input = br.readLine();

            call_count = 0;
            int[] result = solution(input);
            sb.append(result[0])
                    .append(" ")
                    .append(result[1])
                    .append("\n");
        }

        System.out.print(sb);
    }

    private static int[] solution(String input) {
        int[] result = new int[2];

        result[0] = isPalindrome(input);
        result[1] = call_count;

        return result;
    }

    private static int isPalindrome(String input) {
        return recursion(input, 0, input.length()-1);
    }

    private static int recursion(String input, int left, int right) {
        call_count++;
        if(left >= right) return 1;
        else if(input.charAt(left) != input.charAt(right)) return 0;
        else return recursion(input, left+1, right-1);
    }
}