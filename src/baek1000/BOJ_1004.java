package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 1004 : the little Prince
public class BOJ_1004 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        solution(T);

        System.out.print(sb);
    }

    private static void solution(int t) throws IOException {
        while(t-- > 0) {
            int answer = 0;

            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            int endX = Integer.parseInt(input[2]);
            int endY = Integer.parseInt(input[3]);

            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; ++i) {
                String[] planet = br.readLine().split(" ");
                int x = Integer.parseInt(planet[0]);
                int y = Integer.parseInt(planet[1]);
                int radius = Integer.parseInt(planet[2]);

                // Whether the starting point is inside or outside the current planet
                boolean check_start = false;
                // Whether the destination is inside or outside the current planet
                boolean check_end = false;

                // true if the starting point is outside the planet
                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) > Math.pow(radius, 2)) check_start = true;
                // true if the destination is outside the planet
                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) > Math.pow(radius, 2)) check_end = true;

                // If there is only one starting point or one ending point within a planet
                if((check_start && !check_end) || (!check_start && check_end)) answer++;
            }

            sb.append(answer).append("\n");
        }
    }
}