package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class prac1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w,h;
		int temp = 0;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(n == 1) System.out.println(0);
		else {
			for(int i = 1; i < n; i++) {
				if(n%i == 0) {
					w = i;
					h = n/i;
					if(w > h) temp = w - h;
					else temp = h - w;
				}
				result.add(temp);
			}
			
			int[] ans = new int[result.size()];
			
			for(int i = 0; i < ans.length; i++) {
				ans[i] = result.get(i);
			}
			
			Arrays.sort(ans);
			
			System.out.println(ans[0]);
		}
	}
}
