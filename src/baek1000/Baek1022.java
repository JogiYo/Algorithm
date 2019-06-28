package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1022 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int r1 = Integer.parseInt(input[0]);
		int c1 = Integer.parseInt(input[1]);
		int r2 = Integer.parseInt(input[2]);
		int c2 = Integer.parseInt(input[3]);
		
		int max = Math.max(Math.max(Math.abs(r1),Math.abs(r2)),Math.max(Math.abs(c1), Math.abs(c2)));
		int arr_size = 2*max+1;
		int[][] arr = new int[arr_size][arr_size];
		
		int start = (int) (4*Math.pow(max, 2)) + 4*max + 1;
		int size = arr_size-1;
		// make array
		while(start > 0) {
			int i = arr_size-1;
			int j = arr_size-1;
			
			while(true) {
				if(j > 0 && arr[i][j-1] > 0) {
					arr[i][j] = start--;
					break;
				}
				arr[i][j] = start--;
				if(j == 0) break;
				j--;
			}
			
			if(start == 0) break;
			
			i--;
			while(true) {
				if(i > 0 && arr[i-1][j] > 0) {
					arr[i][j] = start--;
					break;
				}
				arr[i][j] = start--;
				if(i == 0) break;
				i--;
			}
			
			j++;
			while(true) {
				if(j < arr_size-1 && arr[i][j+1] > 0) {
					arr[i][j] = start--;
					break;
				}
				arr[i][j] = start--;
				if(j == arr_size-1) break;
				j++;
			}
			
			i++;
			while(true) {
				if(i < arr_size-1 && arr[i+1][j] > 0) {
					arr[i][j] = start--;
					break;
				}
				arr[i][j] = start--;
				if(i == arr_size-1) break;
				i++;
			}
			
			arr_size--;
		}
		//result
		int num = arr[size][size];
		int length = (int)(Math.log10(num)+1);
		for(int i = max + r1; i <= max + r2; i++) {
			for (int j = max + c1; j <= max + c2; j++) {
				System.out.printf("%"+length+"d ", arr[i][j]);
			}
			System.out.print("\n");
		}
	}
}