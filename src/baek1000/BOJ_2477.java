package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2477 : Melon field
// implementation
public class BOJ_2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int[][] arr = new int[6][2];

        for(int i = 0; i < 6; ++i) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(K, arr));


        System.out.print(sb);
    }

    private static int solution(int k, int[][] arr) {
        // Total Rectangle - (Difference between the front and back of the longest vertical * The difference between the front and back of the longest width) * K
        int maxWidth = 0;
        int maxHeight = 0;

        int widthIdx = 0;
        int heightIdx = 0;

        for(int i = 0; i < 6; ++i) {
            if(arr[i][0] == 1 || arr[i][0] == 2) {
                if(maxWidth < arr[i][1]) {
                    maxWidth = arr[i][1];
                    widthIdx = i;
                }
            }
            else {
                if(maxHeight < arr[i][1]) {
                    maxHeight = arr[i][1];
                    heightIdx  = i;
                }
            }
        }

        int W = 0;
        int H = 0;

        if(widthIdx == 0) H = Math.abs(arr[5][1] - arr[1][1]);
        else if(widthIdx == 5) H = Math.abs(arr[4][1] - arr[0][1]);
        else H = Math.abs(arr[widthIdx-1][1] - arr[widthIdx+1][1]);

        if(heightIdx == 0) W = Math.abs(arr[5][1] - arr[1][1]);
        else if(heightIdx == 5) W = Math.abs(arr[4][1] - arr[0][1]);
        else W = Math.abs(arr[heightIdx-1][1] - arr[heightIdx+1][1]);

        return (maxHeight*maxWidth - H*W) * k;
    }
}