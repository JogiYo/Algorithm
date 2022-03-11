package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 1920 : Find Number
// use Binary Search
public class BOJ_1920 {
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
        for(int i = 0; i < result.length; ++i) {
            sb.append(result[i] + "\n");
        }
        System.out.print(sb);
    }

    private static void solution(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            // 1 if there is a value, 0 if not
            if(binarySearch(arr[i]) >= 0) {
                result[i] = 1;
            }
            else result[i] = 0;
        }
    }

    private static int binarySearch(int key) {
        int left = 0;   // left end index of the search range
        int right = numbers.length - 1; // right end index of the search range

        while(left <= right) {
            int mid = (left + right) / 2;
            // When the key value is less than the value of the middle position
            if(key < numbers[mid]) {
                right = mid - 1;
            }
            // When the key value is greater than the value of the middle position
            else if(key > numbers[mid]) {
                left = mid + 1;
            }
            // When the key value and the middle position value are the same
            else return mid;
        }
        // If the value you are looking for does not exist
        return -1;
    }
}
