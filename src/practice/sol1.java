package practice;

public class sol1 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		
		int answer = 0;
		
		int[] check = new int[n];
		for(int i = 0; i < n; i++) {
			check[i] = 1;
		}
		
		for(int i = 0; i < lost.length; i++) {
			check[lost[i]-1] = 0;
		}
		
		for(int i = 0; i < reserve.length; i++) {
			check[reserve[i]-1] += 1;
		}
		
		if(check[0] == 0) {
			if(check[1] == 2) {
				check[0] +=1;
				check[1] -=1;
			}
		}
		
		for(int i = 1; i < check.length-1; i++) {
			if(check[i] == 0) {
				if(check[i-1] == 2 && check[i+1] == 2) {
					check[i] += 1;
					check[i-1] -=1;
				}
				else if(check[i-1] == 2 && check[i+1] !=2) {
					check[i] += 1;
					check[i-1] -=1;
				}
				if(check[i-1] != 2 && check[i+1] == 2) {
					check[i] += 1;
					check[i+1] -=1;
				}
			}
		}
		
		if(check[check.length-1] == 0) {
			if(check[check.length-1] == 2) {
				check[check.length] +=1;
				check[check.length] -=1;
			}
		}
		
		for(int i = 0; i < check.length; i++) {
			if(check[i] > 0) answer++;
		}
		
		System.out.print(answer);
	}
}
