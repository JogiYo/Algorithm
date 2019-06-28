package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1874_other {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int i, input_num, n = Integer.parseInt(br.readLine()), max = 0, top = 0;
		int stack[] = new int[n]; 
		
		while(n-- > 0) {
			input_num = Integer.parseInt(br.readLine());
			if(input_num > max) {
				for(i = max; i < input_num; i++) {
					stack[top++] = i+1;
					sb.append("+\n");
				}
				max = input_num;
			}
			else if(stack[top-1] != input_num) {
					System.out.print("NO");
					return;
			}
			
			top--;
			sb.append("-\n");
		}
		
		System.out.println(sb);
	}
}