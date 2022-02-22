package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 10926 : ??!
// Only IO
public class BOJ_10926 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        sb.append(input + "??!");

        System.out.print(sb);
    }
}
