package baek2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek2941 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			int count = 0;
			
			for(int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
					case 'c' : 
						if(i < s.length()-1) {
							if (s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
								count++;
								i++;
							}
							else count++;
						}
						else count++;
						break;
					
					case 'd' :
						if(i != s.length()-1) {
							if(i < s.length()-2) {
								if (s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') {
									count++;
									i = i + 2;
								}
								else if (s.charAt(i+1) == '-') {
									count++;
									i++;
								}
								else count++;
							}
							else if (s.charAt(i+1) == '-') {
								count++;
								i++;
							}
							else count++;
						}
						else count ++;
						break;
						
					case 'l' :
						if(i < s.length()-1) {
							if (s.charAt(i+1) == 'j') {
								count++;
								i++;
							}
							else count++;
						}
						else count++;
						break;
					
					case 'n' : 
						if(i < s.length()-1) {
							if (s.charAt(i+1) == 'j') {
								count++;
								i++;
							}
							else count++;
						}
						else count++;
						break;
					
					case 's' :
						if(i < s.length()-1) {
							if (s.charAt(i+1) == '=') {
								count++;
								i++;
							}
							else count++;
						}
						else count++;
						break;
					
					case 'z' :
						if(i < s.length()-1) {
							if (s.charAt(i+1) == '=') {
								count++;
								i++;
							}
							else count++;
						}
						else count++;
						break;
					
					default : count++;
				}
			}
			
			bw.write(count + "\n");
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}