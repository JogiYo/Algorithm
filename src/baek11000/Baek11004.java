package baek11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Quick-Selection Algorithm (Quick sort가 아니다.)
// K-번째 큰 수 혹은 작은 수를 찾는 방법 중 가장 효과 적인 Quick Selection
public class Baek11004 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String[] input1 = br.readLine().split(" ");
		int n = Integer.parseInt(input1[0]);
		int k = Integer.parseInt(input1[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(QuickSelect(list,0,n-1,k-1)+"");
		bw.flush();
		bw.close();
	}

	private static void swap(int[] list, int a, int b) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	private static int QuickSelect(int[] list, int left, int right, int k) {
		int pivot = partition(list, left, right);
		if(pivot == k) return list[pivot];
		else if(pivot > k) return QuickSelect(list, left, pivot-1, k);
		else return QuickSelect(list, pivot+1, right, k);	
	}

	private static int partition(int[] list, int left, int right) {
		int pivot = list[right];
		int i = left-1;
		for(int j = left; j < right; j++) {
			if(list[j] < pivot) {
				i++;
				swap(list, i, j);
			}
		}
		i++;
		swap(list, i ,right);
		return i;
	}
}