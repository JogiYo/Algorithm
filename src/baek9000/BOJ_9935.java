package baek9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 9935 : String explosion
// use Stack
public class BOJ_9935 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String line = br.readLine();
        String regex = br.readLine();

        solution(line, regex);
        System.out.print(sb);
    }

    private static void solution(String line, String regex) {
        int regex_len = regex.length();
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < line.length(); ++i) {
            stk.push(line.charAt(i));

            /*
             * If the length of characters put on the stack is longer than the length of the explosion string,
             * it searches for an explosion string.
             */
            if(stk.size() >= regex_len) {
                boolean find = true;

                for(int j = 0; j < regex_len; ++j) {
                    if(stk.get(stk.size() - regex_len + j) != regex.charAt(j)) {
                        find = false;
                        break;
                    }
                }

                if(find) {
                    int count = regex_len;
                    while(count-- > 0) {
                        stk.pop();
                    }
                }
            }
        }

        if(stk.isEmpty()) sb.append("FRULA");
        else {
            for(Character c : stk) {
                sb.append(c);
            }
        }
    }
}