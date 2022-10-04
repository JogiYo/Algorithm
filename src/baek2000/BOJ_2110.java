package baek2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int[] house;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solution(n, c);
        System.out.print(sb);
    }

    private static void solution(int n, int c) throws IOException {
        house = new int[n];
        
        for(int i = 0; i < n; ++i) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
    }
}
