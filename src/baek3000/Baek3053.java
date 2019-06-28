package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek3053 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		double r = (double) Integer.parseInt(br.readLine());
		double pi = Math.PI;
		
		System.out.printf("%.6f\n", r*r*pi);
		System.out.printf("%.6f", 2*r*r);
	}
}