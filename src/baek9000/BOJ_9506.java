package baek9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ 9506 : Sum of factors
public class BOJ_9506 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
        System.out.print(sb);
    }

    private static void solution() throws IOException {
        int input = Integer.parseInt(br.readLine());

        while(input != -1) {
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= input/2; ++i) {
                if(input % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }

            if(sum != input) {
                sb.append(input).append(" is NOT perfect.").append("\n");
            }
            else {
                sb.append(input).append(" = ").append(list.get(0));
                for(int i = 1; i < list.size(); ++i) {
                    sb.append(" + ").append(list.get(i));
                }
                sb.append("\n");
            }

            input = Integer.parseInt(br.readLine());
        }
    }
}