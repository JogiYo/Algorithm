package baek10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 10798 : read vertically
public class BOJ_10798 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
        System.out.print(sb);
    }

    private static void solution() throws IOException {
        int max = 0;
        String[] str = new String[5];

        for(int i = 0; i < 5; ++i) {
            str[i] = br.readLine();
            max = Math.max(max, str[i].length());
        }

        char[][] chars =  new char[5][max];
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < max; ++j) {
                if(j >= str[i].length()) chars[i][j] = ' ';
                else chars[i][j] = str[i].charAt(j);
            }
        }

        for(int j = 0; j < max; ++j) {
            for(int i = 0; i < 5; ++i) {
                if(chars[i][j] == ' ') continue;
                sb.append(chars[i][j]);
            }
        }
    }
}