package baek2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 2110 : Router installation
// use Binary Search
public class BOJ_2110 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int[] house;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solution(n, c);
        System.out.print(sb);
    }

    private static void solution(int n, int c) throws IOException {
        house = new int[n];

        for(int i = 0; i < n; ++i) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house); // Ascending Sort for Binary Search

        int left = 1; // minimum distance
        int right = house[n-1] - house[0] + 1;

        // Upper Bound
        while(left < right) {
            int mid = (left + right) / 2;

            /*
             * If the number of routers that can be installed for a given distance is less than the number of c,
             * reduce right because the distance must be narrowed.
             */
            if(installable(mid) < c) {
                right = mid;
            }
            else {
                /*
                 * If the number of routers that can be installed is greater than or equal to the number of c,
                 * As you increase the distance, find the maximum distance that the minimum distance can have.
                 */
                left = mid + 1;
            }
        }

        /*
         * Since Upper Bound indicates the first value exceeding the search value,
         * the value minus 1 becomes the maximum value that satisfies the conditional expression.
         */
        sb.append(left - 1);
    }

    private static int installable(int dist) {
        int count = 1;
        int cur_loc = house[0];

        for(int i = 1; i < house.length; ++i) {
            int loc = house[i];

            /*
             * If the distance between the location of the house you are currently searching for and the location of the house you just installed is greater than or equal to the minimum distance (dist),
             * It increases the number of router installations and updates the last installation location.
             */
            if(loc - cur_loc >= dist) {
                count++;
                cur_loc = loc;
            }
        }

        return count;
    }
}