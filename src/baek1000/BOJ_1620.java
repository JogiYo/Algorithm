package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// BOJ 1620 : I'm Pocketmon Master Lee Da Som
// use HashMap
public class BOJ_1620 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        solution(n, m);
        System.out.print(sb);
    }

    private static void solution(int n, int m) throws IOException {
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < n; ++i) {
            String pocket = br.readLine();
            String num = Integer.toString(i+1);
            map.put(pocket, num);
            map.put(num, pocket);
        }

        for(int i = 0; i < m; ++i) {
            sb.append(map.get(br.readLine())).append("\n");
        }
    }
}