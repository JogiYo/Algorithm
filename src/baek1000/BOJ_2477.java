package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int[][] arr = new int[6][2];

        for(int i = 0; i < arr.length; ++i) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        sb.append(solution(K, arr));


        System.out.print(sb);
    }

    private static int solution(int k, int[][] arr) {
        int maxWidth = 0;
        int maxHeight = 0;
        int minWidth = Integer.MAX_VALUE;
        int minHeight = Integer.MAX_VALUE;

        for (int[] ints : arr) {
            int direction = ints[0];
            int length = ints[1];

            if (direction == 3 || direction == 4) {
                maxHeight = Math.max(maxHeight, length);
                minHeight = Math.min(minHeight, length);
            } else {
                maxWidth = Math.max(maxWidth, length);
                minWidth = Math.min(minWidth, length);
            }
        }

        return (maxHeight*maxWidth - minHeight*minWidth) * k;
    }
}