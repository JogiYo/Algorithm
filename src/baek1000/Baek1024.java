package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// N = x + (x+1) + (x+2) + ... + (x+L-1)
//   = Lx + (1 + 2 + ... + L-1)
//   = Lx + L * (L-1) / 2
// x = (N - L*(L-1)/2) / L
// **** x는 정수이며 0보다 같거나 커야한다. x >= 0 && (N-L*(L-1)/2) % L == 0  ****
public class Baek1024 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int x = -1;
		boolean flag = false;
		for(int i = L; i <= 100; i++) {
			if((N - seqSum(i-1)) / i >= 0 && (N - seqSum(i-1)) % i == 0) {
				x = (N - seqSum(i-1)) / i;
				printSeq(x, i);
				flag = true;
				break;
			}
		}
		
		if(flag) System.out.print(sb);
		else {
			sb.append(-1);
			System.out.print(sb);
		}
	}
	
	public static int seqSum(int n) {
		return n * (n + 1) / 2;
	}
	
	public static void printSeq(int n, int l) {
		for(int i = n; i < l + n; i++) {
			sb.append(i + " ");
		}
	}
}