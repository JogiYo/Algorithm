package baek10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 10815 : Number card
// use binary search
public class BOJ_10815 {
    static  int[] cards;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        cards = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; ++i) {
            cards[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        int[] numbers = new int[m];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < m; ++i) {
            numbers[i] = Integer.parseInt(input2[i]);
        }

        int[] result = solution(numbers);
        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" " + result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];

        for(int i = 0; i < numbers.length; ++i) {
            result[i] = binarySearch(numbers[i], 0, cards.length-1);
        }

        return result;
    }

    private static int binarySearch(int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if(key == cards[mid]) return 1;
            else if(key < cards[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return 0;
    }
}