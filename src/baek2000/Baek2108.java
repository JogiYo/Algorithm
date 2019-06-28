package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek2108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int range;
		int most_freq = 0;
		int sum = 0;
		double avg;
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		//Æò±Õ
		avg = (double)sum/(double)n;
		bw.write(Math.round(avg)+"\n");
		
		Arrays.sort(arr);
		//Áß¾Ó°ª
		bw.write(arr[n/2]+"\n");
		
		//¹üÀ§
		range = arr[n-1] - arr[0];
		int[] freq = new int[range+1];
		
		for(int i = 0; i < arr.length; i++) {
			freq[arr[i]-arr[0]]++;
			if(freq[arr[i]-arr[0]] > most_freq) most_freq = freq[arr[i]-arr[0]];
		}
		boolean flag1 = false;
		int most_freq_value = 0;
		
		for(int i = 0; i < freq.length; i++) {
			if(freq[i] == most_freq && !flag1) {
				flag1 = true;
				most_freq_value = i + arr[0];
			}
			else if(freq[i] == most_freq && flag1) {
				most_freq_value = i + arr[0];
				break;
			}
		}		
		bw.write(most_freq_value + "\n" + range);
		bw.flush();
		bw.close();
	}
}