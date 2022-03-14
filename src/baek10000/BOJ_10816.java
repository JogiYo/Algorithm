package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 10816 : Number Card 2
// use Binary Search
public class BOJ_10816 {
    static int[] result;
    static int[] numbers;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input_1 = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] input_2 = br.readLine().split(" ");
        result = new int[m];

        numbers = new int[n];
        int[] arr = new int[m];

        for(int i = 0; i < n; ++i) {
            numbers[i] = Integer.parseInt(input_1[i]);
        }
        // Sorting for Binary Search
        Arrays.sort(numbers);

        for(int i = 0; i < m; ++i) {
            arr[i] = Integer.parseInt(input_2[i]);
        }

        solution(arr);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" " + result[i]);
        }
        System.out.print(sb);
    }

    private static void solution(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            int key = arr[i];
            result[i] = upperLimit(key) - lowerLimit(key);
        }
    }

    private static int upperLimit(int key) {
        int left = 0;
        int right = numbers.length;

        while(left < right) {
            /*
             *  Since overflow can occur,
             *  the starting point + (difference between the end and the beginning)/2 can be obtained as an intermediate value.
             */
            int mid = left +  ((right - left) / 2);

            if(key < numbers[mid]) {
                right = mid;
            }
            else left = mid + 1;
        }

        return left;
    }

    private static int lowerLimit(int key) {
        int left = 0;
        int right = numbers.length;

        while(left < right) {
            int mid = left +  ((right - left) / 2);

            if(key <= numbers[mid]) {
                right = mid;
            }
            else left = mid + 1;
        }

        return left;
    }
}
