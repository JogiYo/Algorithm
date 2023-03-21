package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 10101 : Memorize triangles
public class BOJ_10101 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int a_side = Integer.parseInt(br.readLine());
        int b_side = Integer.parseInt(br.readLine());
        int c_side = Integer.parseInt(br.readLine());
        solution(a_side, b_side, c_side);
        System.out.print(sb);
    }

    private static void solution(int aSide, int bSide, int cSide) {
        if(aSide + bSide + cSide != 180) sb.append("Error");
        else {
            if(aSide == bSide && bSide == cSide) sb.append("Equilateral");
            else if(aSide == bSide || aSide == cSide || bSide == cSide) sb.append("Isosceles");
            else sb.append("Scalene");
        }
    }
}