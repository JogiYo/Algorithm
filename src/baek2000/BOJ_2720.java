package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2720 : Laundry owner DongHyuk
public class BOJ_2720 {
    static BufferedReader br;
    static StringBuilder sb;
    static int[] unit = {25 ,10, 5, 1};
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int[] result = solution(c);
            sb.append(result[0]);
            for(int i = 1; i < 4; ++i) sb.append(" ").append(result[i]);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int[] solution(int c) {
        int[] answer = new int[4];

        for(int i = 0; i < 4; ++i) {
            answer[i] = c / unit[i];
            c %= unit[i];
        }

        return answer;
    }
}