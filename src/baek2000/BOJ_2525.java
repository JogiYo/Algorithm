package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_2525 : Oven clock
// use conditional sentence
public class BOJ_2525 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int mins = Integer.parseInt(input[1]);
        int times = Integer.parseInt(br.readLine());

        sb.append(solution(hour, mins, times) + "");

        System.out.print(sb);
    }

    private static String solution(int hour, int mins, int times) {
        int total = mins + times;

        if(total >= 60) {
            int add_hour = total / 60;
            total %= 60;
            hour += add_hour;
        }

        if(hour >= 24) {
            hour -= 24;
        }

        return hour + " " +  total;
    }
}
