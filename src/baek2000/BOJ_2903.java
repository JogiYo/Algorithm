package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2903 : Center shift algorithm
// find pattern
public class BOJ_2903 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(solution(n));
        System.out.print(sb);
    }

    /*
     * Determine the number of points that can fit on one side of a square.
     */
    private static int solution(int n) {
        int answer;
        int pointCount = 3;
        // If there are n points that can be printed on one side, there are n-1 more points on the next.
        for(int i = 1; i < n; ++i) pointCount = pointCount + (pointCount-1);

        // The number of dots is the square of the number of dots that can fit on a side.
        answer = (int)Math.pow(pointCount, 2);
        return answer;
    }
}