package baek3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 3034 : Angry ChangYoung
// Pythagorean theorem
public class BOJ_3034 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        double n = Double.parseDouble(input[0]);
        double w = Double.parseDouble(input[1]);
        double h = Double.parseDouble(input[2]);

        solution(n, w, h);
        System.out.print(sb);
    }

    private static void solution(double n, double w, double h) throws IOException {
        double diagonal = Math.sqrt(w*w + h*h);

        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num <= diagonal) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }
    }
}