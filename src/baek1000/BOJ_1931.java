package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        /*
         *  time[i][0] is start point
         *  time[i][1] is end point
         */
        int[][] time = new int[N][2];

        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(time));

        System.out.print(sb);
    }

    private static int solution(int[][] time) {
        int count = 0;
        // sort by end time
        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });
    }
}
