package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baek1260 {
	public static int N, M, V;
	public static int x, y;
	
	public static int[][] graph = new int[1001][1001];
	public static boolean visited[] = new boolean[10001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		V = Integer.parseInt(str[2]);
		
		for(int i = 1; i <= M; i++) {
			String[] num = br.readLine().split(" ");
			x = Integer.parseInt(num[0]);
			y = Integer.parseInt(num[1]);
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(V);
		
		for(int i = 1; i <= N; i++) {
			visited[i] = false;
		}
		
		bfs(V);
		
		System.out.println(sb);
	}

	private static void dfs(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		int out_value;
		
		stack.push(v);
		
		while(!stack.isEmpty()) {
			out_value = stack.pop();
			
			if(visited[out_value] == false) {
				sb.append(out_value + " ");
				visited[out_value] = true;
				
				for(int i = N; i >= 1; i--) {
					if(graph[out_value][i] == 1 && visited[i] == false) {
						stack.push(i);
					}
				}
			}
		}
		
		sb.append("\n");
	}
	
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int out_value;
		
		queue.offer(v);
		visited[v] = true;
		sb.append(v + " ");
		
		while(!queue.isEmpty()) {
			out_value = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(graph[out_value][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}
	}
}