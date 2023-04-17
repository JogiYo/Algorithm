package baek19000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 19532 : Mathematics is a non-face-to-face class
// use Brute Force
public class BOJ_19532 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i = 0; i < 6; ++i) arr[i] = Integer.parseInt(st.nextToken());

        int[] result = solution(arr);
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }

    private static int[] solution(int[] arr) {
        int resultX = 0;
        int resultY = 0;
        // Since the range of x,y is -999 to 999, it can be solved through brute force.
        for(int x = -999; x < 1000; ++x) {
            for(int y = -999; y < 1000; ++y) {
                if((arr[0]*x + arr[1]*y == arr[2]) && (arr[3]*x + arr[4]*y == arr[5])) {
                    resultX = x;
                    resultY = y;
                }
            }
        }

        return new int[] {resultX, resultY};
    }
}