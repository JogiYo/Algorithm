package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// BOJ 1764 : who has neither heard nor seen
// use HashMap
public class BOJ_1764 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            map.put(br.readLine(), 1);
        }

        for(int i = 0; i < m; ++i) {
            String str = br.readLine();
            if(map.getOrDefault(str, 0) != 0) list.add(str);
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}