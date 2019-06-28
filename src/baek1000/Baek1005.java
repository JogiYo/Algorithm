package baek1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//위상정렬을 이용, 거기에서 dynamic programming을 이용한다.
public class Baek1005 {
	static int n;
	static int k;
	static int[] d;
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			d = new int[n+1];
			
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			
			for(int i = 0; i < n+1; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			int[] indegree = new int[n+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.get(x).add(y);
				indegree[y]++;
			}
			
			int w = Integer.parseInt(br.readLine());
			
			topologicalSort(indegree, list, w);
		}
	}

	private static void topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] result = new int[n+1];
		
		for(int i = 1; i <=n; i++) {
			result[i] = d[i];
			
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(Integer i : list.get(node)) {
				result[i] = Math.max(result[i], result[node] + d[i]);
				indegree[i]--;
				
				if(indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}
		System.out.println(result[w]);
	}
}