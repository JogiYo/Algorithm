package baek11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//페르마의 소정리와 거듭제곱을 이용한 풀이
public class Baek11401 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		long p = 1000000007;
		
		long[] facto = new long[n+1];
		facto[0] = facto[1] = 1;
		
		for(int i=2; i <= n; i++) facto[i] = (i * facto[i-1]) % p;
		long base = (facto[k] * facto[n-k]) % p;
		
		long index = p-2;
		long fermat = 1;
		
		while(index > 0) {
			if(index % 2 == 1) {
				fermat *= base;
				fermat %= p;
			}
			base = (base * base) % p;
			index /= 2;
		}
		sb.append(((facto[n]%p) * (fermat%p)) % p);
		System.out.println(sb);
	}
}