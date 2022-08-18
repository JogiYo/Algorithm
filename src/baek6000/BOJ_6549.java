package baek6000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 6549 : largest rectangle in histogram
// use divide and conquer
public class BOJ_6549 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] histogram;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            histogram = new int[n];

            for(int i = 0; i < n; ++i) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, n-1)).append("\n");

            histogram = null;
        }
        System.out.print(sb);
    }

    private static long getArea(int left, int right) {
        /*
         *  If the width is 1,
         *  it is returned immediately because the height is the width.
         */
        if(left == right) return histogram[left];

        int mid = (left + right) / 2;

        long leftArea = getArea(left, mid);
        long rightArea = getArea(mid+1, right);

        long max = Math.max(leftArea, rightArea);

        max = Math.max(max, getMidArea(left, right, mid));

        return max;
    }

    // Method to find the area of ​​the midpoint area
    private static long getMidArea(int left, int right, int mid) {
        int left_dir = mid;
        int right_dir = mid;

        long height = histogram[mid];

        long maxArea = height;

        // Repeat until both ends are out of bounds
        while(left < left_dir && right_dir < right) {
            /*
             * Select the higher value among the heights of the next two columns,
             * but the updated height must be less than or equal to the existing height.
             */
            if(histogram[left_dir-1] < histogram[right_dir+1]) {
                right_dir++;
                height = Math.min(height, histogram[right_dir]);
            }
            else {
                left_dir--;
                height = Math.min(height, histogram[left_dir]);
            }

            maxArea = Math.max(maxArea, height * (right_dir - left_dir + 1));
        }

        // If the right section has not been searched until the end, it will search even.
        while(right_dir < right) {
            right_dir++;
            height = Math.min(height, histogram[right_dir]);
            maxArea = Math.max(maxArea, height * (right_dir - left_dir + 1));
        }
        // If the left section has not been searched until the end, it is searched even.
        while(left < left_dir) {
            left_dir--;
            height = Math.min(height, histogram[left_dir]);
            maxArea = Math.max(maxArea, height * (right_dir - left_dir + 1));
        }

        return maxArea;
    }
}