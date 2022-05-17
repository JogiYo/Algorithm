package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

// BOJ 11478 : number of different substrings
// use Set
public class BOJ_11478 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        sb.append(solution(s));
        System.out.print(sb);
    }

    private static int solution(String s) {
        HashSet<String> set = new HashSet<>();

        for(int i = 1; i <= s.length(); ++i) {
            for(int j = 0; j <= s.length() - i; ++j) {
                set.add(s.substring(j, j + i));
            }
        }

        return set.size();
    }
}