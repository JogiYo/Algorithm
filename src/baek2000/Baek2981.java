package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://memilshouse.tistory.com/43
// https://www.acmicpc.net/board/view/11630
public class Baek2981 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		int dif = num[1] - num[0];
		for(int i = 1; i < n-1; i++) {
			dif = gcd(dif, num[i+1] - num[i]);
		}
		
		for(int i = 2; i * i <= dif; i++) {
			if (dif % i == 0) {
				if(!list.contains(i)) {
					list.add(i);
				}
				if(i*i < dif) {
					if(!list.contains(dif/i)) {
						list.add(dif/i);
					}
				}	
			}
		}
		list.add(dif);
		Collections.sort(list);
		
		for(int i = 0; i < list.size()-1; i++) {
			sb.append(list.get(i) + " ");
		}
		sb.append(list.get(list.size()-1));
		System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		int r;
		while(b != 0) {
			r = a%b;
			a = b;
			b = r;
		}
		
		return a;
	}
}