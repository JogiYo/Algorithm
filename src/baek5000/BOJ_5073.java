package baek5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 5073 : triangle and three sides
public class BOJ_5073 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
        System.out.print(sb);
    }

    private static void solution() throws IOException {
        int[] sides = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sides[0] = Integer.parseInt(st.nextToken());
        sides[1] = Integer.parseInt(st.nextToken());
        sides[2] = Integer.parseInt(st.nextToken());

        while(!(sides[0] == 0 && sides[1] == 0 && sides[2] == 0)) {
            Arrays.sort(sides);
            if(sides[2] >= sides[0] + sides[1]) sb.append("Invalid").append("\n");
            else {
                if(sides[0] == sides[1] && sides[1] == sides[2]) sb.append("Equilateral").append("\n");
                else if(sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]) sb.append("Isosceles").append("\n");
                else sb.append("Scalene").append("\n");
            }

            st = new StringTokenizer(br.readLine());
            sides[0] = Integer.parseInt(st.nextToken());
            sides[1] = Integer.parseInt(st.nextToken());
            sides[2] = Integer.parseInt(st.nextToken());
        }
    }
}