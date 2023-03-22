package baek14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 14215 : Three bars
// Understanding the properties of triangles
public class BOJ_14215 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sb.append(solution(a,b,c));
        System.out.print(sb);
    }

    private static int solution(int a, int b, int c) {
        int[] sides = new int[3];
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;

        Arrays.sort(sides);
        if(sides[0] + sides[1] > sides[2]) return sides[0] + sides[1] + sides[2];
        else return 2*(sides[0] + sides[1]) - 1;
    }
}