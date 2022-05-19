package baek1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 1358 : Hockey
// distance between coordinates
public class BOJ_1358 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        double w = Double.parseDouble(input[0]);
        double h = Double.parseDouble(input[1]);
        double x = Double.parseDouble(input[2]);
        double y = Double.parseDouble(input[3]);
        int p = Integer.parseInt(input[4]);

        sb.append(solution(w, h, x, y, p));
        System.out.print(sb);
    }

    private static int solution(double w, double h, double x, double y, int p) throws IOException {
        int result = 0;
        int xw = (int)(x + w);
        int yh = (int)(y + h);
        double radius = h/2;
        double yr = y + radius;

        while(p-- > 0) {
            String[] input = br.readLine().split(" ");
            double px = Double.parseDouble(input[0]);
            double py = Double.parseDouble(input[1]);

            if(px >= x && py >= y && px <= xw && py <= yh) result++;
            else if(px < x) {
                if(Math.sqrt(Math.pow((x-px), 2) + Math.pow((yr-py), 2)) <= radius) result++;
            }
            else if(px > xw) {
                if(Math.sqrt(Math.pow((xw-px), 2) + Math.pow((yr-py), 2)) <= radius) result++;
            }
        }

        return result;
    }
}