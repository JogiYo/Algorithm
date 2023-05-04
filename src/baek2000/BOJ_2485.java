package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 2485 : Avenue
// use GCD
public class BOJ_2485 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] streets = new int[n];
        for(int i = 0; i < n; ++i) {
            streets[i] = Integer.parseInt(br.readLine());
        }

        sb.append(solution(streets));
        System.out.print(sb);
    }

    private static int solution(int[] streets) {
        int answer = 0;

        // Ascending sort
        Arrays.sort(streets);
        // Store the difference in street tree position as an array
        int[] arr = new int[streets.length-1];
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = streets[i+1] - streets[i];
        }

        // Find the greatest common divisor of all numbers
        int gcdNum = arr[0];
        for(int i = 1; i < arr.length; ++i) {
            gcdNum = gcd(gcdNum, arr[i]);
        }

        // The difference between the first and last elements divided by the greatest common divisor + 1 is the number of all avenues.
        // Subtract the number of original street trees from that to get the number of additional street trees.
        answer = (streets[streets.length-1] - streets[0]) / gcdNum + 1 - streets.length;

        return answer;
    }

    private static int gcd(int num1, int num2) {
        if(num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}