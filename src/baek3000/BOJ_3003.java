package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 3003 : King, Queen, Rook, Bishop, Knight, Pawn
public class BOJ_3003 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] components = {1,1,2,2,2,8};
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int[] now = new int[6];
        for(int i = 0; i < 6; ++i) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        solution(now);
        System.out.print(sb);
    }

    private static void solution(int[] now) {
        sb.append(components[0] - now[0]);
        for(int i = 1; i < now.length; ++i) {
            sb.append(" ").append(components[i] - now[i]);
        }
    }
}