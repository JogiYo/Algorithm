package baek11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ11650, Sorting Problem.
// N points above the two-dimensional plane are given. 
// The problem of aligning coordinates with the order in which the coordinates x are increased, 
// and if the coordinates x are equal, the order in which the y-coordinates are increased.
// I solved the problem through a merge sort
public class BOJ11650 {
	ArrayList<Point> mergeList = new ArrayList<Point>();
	
	public BOJ11650() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			mergeList.add(new Point(x,y));
		}
		
		// sorting
		this.mergeSort(mergeList, mergeList.size());
		
		// print result
		for(int i = 0; i < n-1; i++) {
			sb.append(mergeList.get(i).x + " " + mergeList.get(i).y +"\n");
		}
		sb.append(mergeList.get(n-1).x + " " + mergeList.get(n-1).y);
		System.out.print(sb);
	}
	
	// sorting method
	public void mergeSort(ArrayList<Point> list, int index_count) {
		if(index_count<2) return;
		
		int mid = index_count/2;
		
		ArrayList<Point> left_Array = new ArrayList<Point>();
		ArrayList<Point> right_Array = new ArrayList<Point>();
		
		for(int i = 0; i < mid; i++) left_Array.add(i, list.get(i));
		for(int j = mid; j < index_count; j++) right_Array.add(j-mid, list.get(j));
		
		this.mergeSort(left_Array, mid);
		this.mergeSort(right_Array, index_count-mid);
		
		this.merge(list, left_Array, mid, right_Array, index_count-mid);
		
	}
	
	// merge method
	public void merge(ArrayList<Point> list, ArrayList<Point> left_Array, int left_count, ArrayList<Point> right_Array, int right_count) {
		int i = 0, j = 0, k = 0;
		
		while( i < left_count && j < right_count) {
			if(left_Array.get(i).x < right_Array.get(j).x) list.set(k++, left_Array.get(i++));
			
			// Sort in ascending order using y-values when x-values are equal
			else if(left_Array.get(i).x == right_Array.get(j).x) {
				if(left_Array.get(i).y < right_Array.get(j).y) list.set(k++, left_Array.get(i++));
				else list.set(k++, right_Array.get(j++));
			}
			else list.set(k++, right_Array.get(j++));		
		}
		
		while(i<left_count) {
			list.set(k++, left_Array.get(i++));
		}
		while(j<right_count) {
			list.set(k++, right_Array.get(j++));
		}
	}
	
	public static void main(String[] args) throws IOException {
		new BOJ11650();
	}
	
	class Point {
		int x;
		int y;
		
		public Point() {
			this.x = 0;
			this.y = 0;
		}
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}