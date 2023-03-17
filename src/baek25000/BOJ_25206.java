package baek25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// BOJ 25206 : What's your rating
public class BOJ_25206 {
    static BufferedReader br;
    static StringBuilder sb;
    static String[] gradeList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
    static double[] gradeScore = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
        System.out.print(sb);
    }

    private static void solution() throws IOException {
        HashMap<String, Double> hm = new HashMap<>();
        for(int i = 0; i < gradeList.length; ++i) {
            hm.put(gradeList[i], gradeScore[i]);
        }

        double totalSum = 0;
        double gradeSum = 0;
        for(int i = 0; i < 20; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String score = st.nextToken();

            if(score.equals("P")) continue;

            totalSum += grade * hm.get(score);
            gradeSum += grade;
        }

        if(totalSum != 0) totalSum /= gradeSum;
        sb.append(String.format("%.6f", totalSum));
    }
}