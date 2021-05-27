package baek2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ 2580 : Sudoku
// Backtracking
public class BOJ_2580 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		for(int i = 0; i < 9; ++i) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < 9; ++j) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		sudoku(arr, 0, 0);
	}

	private static void sudoku(int[][] arr, int row, int col) {
		// When the row is filled, start from the first column of the next row.
		if(col == 9) {
			sudoku(arr, row + 1, 0);
			return;
		}
		// print when both rows and columns are filled
		if(row == 9) {
			for(int i = 0; i < 9; ++i) {
				for(int j = 0; j < 9; ++j) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		// Search for possible numbers from 1 to 9
		if(arr[row][col] == 0) {
			for(int i = 1; i <= 9; ++i) {
				// check possible
				if(possible(arr, row, col, i)) {
					arr[row][col] = i;
					sudoku(arr, row, col + 1);
				}
			}
			// When the Sudoku condition is not satisfied,
			// the value is returned again.
			arr[row][col] = 0;
			return;
		}
		
		sudoku(arr, row, col+1);
	}
	
	private static boolean possible(int[][] arr, int row, int col, int num) {
		// Row check
		for(int i = 0; i < 9; ++i) {
			if(arr[row][i] == num) {
				return false;
			}
		}
		// Column check
		for(int i = 0; i < 9; ++i) {
			if(arr[i][col] == num) {
				return false;
			}
		}
		// Check for duplicate elements in 3*3 cells
		int s_row = (row/3) * 3;
		int s_col = (col/3) * 3;
		for(int i = s_row; i < s_row + 3; ++i) {
			for(int j = s_col; j < s_col + 3; ++j) {
				if(arr[i][j] == num) return false;
			}
		}
		
		return true;
	}
}