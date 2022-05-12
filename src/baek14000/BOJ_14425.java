package baek14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// BOJ 14425 : String Set
// use Hashmap
public class BOJ_14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i = 0; i < n; ++i) {
            map.put(br.readLine(), 1);
        }

        for(int i = 0; i < m; ++i) {
            String str = br.readLine();
            if(map.getOrDefault(str, 0) != 0) cnt++;
        }

        sb.append(cnt + "");
        System.out.print(sb);
    }
}