package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// BOJ 10816 : Number Card 2
// use HashMap
public class BOJ_10816_hashmap {
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
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < numbers.length; ++i) {
            hashMap.put(numbers[i], hashMap.getOrDefault(numbers[i], 0) + 1);
        }

        for(int i = 0; i < arr.length; ++i) {
            result[i] = hashMap.getOrDefault(arr[i], 0);
        }
    }
}
