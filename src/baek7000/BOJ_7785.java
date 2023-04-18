package baek7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ 7785 : person in the company
// use HashMap
public class BOJ_7785 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] result = solution(n);

        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) sb.append("\n").append(result[i]);
        System.out.print(sb);
    }

    private static String[] solution(int n) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inout = st.nextToken();

            if(inout.equals("enter")) map.put(name, 1);
            else map.remove(name);
        }

        String[] result = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(result, Collections.reverseOrder());

        return result;
    }
}