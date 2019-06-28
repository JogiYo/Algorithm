package practice;

import java.util.*;

public class sol {
	public static void main(String[] args) {
		 int[]array = {1,5,2,6,3,7,4};
		 int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		 int[] answers = new int[5-2+1];
		 
		 int x = commands.length;
		 
		 System.arraycopy(array, 1, answers, 0, 4);
		 Arrays.sort(answers);
		
		 int i = answers[3-1];
		 
		 System.out.print(i);
	}
}
