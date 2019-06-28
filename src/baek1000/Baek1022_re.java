package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://simsimjae.tistory.com/2
// https://m.blog.naver.com/PostView.nhn?blogId=movie_jo&logNo=10173677469&proxyReferer=https%3A%2F%2Fwww.google.com%2F
public class Baek1022_re {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int r1 = Integer.parseInt(input[0]);
		int c1 = Integer.parseInt(input[1]);
		int r2 = Integer.parseInt(input[2]);
		int c2 = Integer.parseInt(input[3]);
		
		int max = Math.max(Math.max(point(r1,c1), point(r2,c2)), Math.max(point(r1,c2), point(r2,c1)));
		int length = (int)(Math.log10(max)+1);
		
		for(int i = r1; i <= r2; i++) {
			for(int j = c1; j <= c2; j++) {
				System.out.printf("%"+length+"d ", point(i,j));
			}
			System.out.print("\n");
		}
	}
	
	public static int point(int x, int y) {
		if(x >= 0 && -1 * x <= y&& y <= x) {
			return (x * 2 + 1)*(x * 2 + 1) - (x - y);
		}
		else if(x<0 && x <= y && y <= Math.abs(x) ) { 
			return (Math.abs(x) * 2)*(Math.abs(x) * 2) - (Math.abs(x)-1) -y ;
		} 
		else if(y>x&& y>-1*x) { 
			return ((y - 1) * 2 +1 )* ((y - 1) * 2 + 1) + (y - x); 
		} 
		else { 
			return (Math.abs(y) * 2)*(Math.abs(y) * 2) + (x - y + 1); 
		}
	}
}