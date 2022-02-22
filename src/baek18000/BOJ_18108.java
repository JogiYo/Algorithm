package baek18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_18108 : I was born in 1998, I was born in Thailand in 2541?!
// Implementation
public class BOJ_18108 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        sb.append((input - 543));

        System.out.print(sb);
    }
}
