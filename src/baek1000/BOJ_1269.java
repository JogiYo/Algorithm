package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// BOJ 1269 : Symmetric Differential Set
// use HashMap
public class BOJ_1269 {
    static BufferedReader br;
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        sb.append(solution(n, m));
        System.out.print(sb);
    }

    private static int solution(int n, int m) throws IOException {
        map = new HashMap<>();
        int cnt = 0;

        String[] n_number = br.readLine().split(" ");
        for(String s : n_number) {
            map.put(s, 1);
        }

        String[] m_number = br.readLine().split(" ");
        for(String s : m_number) {
            if(map.getOrDefault(s, 0) != 0) cnt++;
        }

        return (n + m) - 2*cnt;
    }
}