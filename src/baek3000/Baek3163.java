package baek3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

// https://sexycoder.tistory.com/100 Âü°í
// https://danco.tistory.com/32
// https://blog.myungwoo.kr/32
// https://baeharam.github.io/ps/2018/12/31/ps-boj3163/
public class Baek3163 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int l = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);
			
			Deque<Integer> idlist = new LinkedList<Integer>();
			ArrayList<Pair> ant = new ArrayList<Pair>();
			Deque<Integer> fallList = new LinkedList<Integer>();			
			for(int i = 0; i < n; i++) {
				String[] posid = br.readLine().split(" ");
				int pos = Integer.parseInt(posid[0]);
				int id = Integer.parseInt(posid[1]);
				
				idlist.offerLast(id);
				
				if(id < 0 ) {
					ant.add(new Pair(pos,id));	
				}
				else ant.add(new Pair(l-pos,id));
			}	
			
			Collections.sort(ant);
			
			for(int i = 0; i < ant.size(); i++) {
				int frontValue = idlist.peekFirst();
				int backValue = idlist.peekLast();
				
				if(i != ant.size()-1 && ant.get(i).getPos() == ant.get(i+1).getPos()) {
					if(frontValue < backValue) {
						fallList.offerLast(frontValue);
						fallList.offerLast(backValue);
					}
					else {
						fallList.offerLast(backValue);
						fallList.offerLast(frontValue);
					}
					idlist.pollLast();
					idlist.pollFirst();
					i++;
				}
				else if(ant.get(i).getId() < 0) {
					fallList.offerLast(frontValue);
					idlist.pollFirst();
				}
				else {
					fallList.offerLast(backValue);
					idlist.pollLast();
				}
			}
			for(int i = 0; i < k-1; i++) {
				fallList.pollFirst();
			}
			
			sb.append(fallList.pollFirst()+"\n");
		}
		System.out.println(sb);
	}
}

class Pair implements Comparable<Pair>{
	private int pos;
	private int id;	
	
	public Pair(int pos, int id) {
		this.pos = pos;
		this.id = id;
	}
	
	public int getPos() {
		return this.pos;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public int compareTo(Pair pr) {
		if(pos > pr.getPos()) {
			return 1;
		}
		else if (pos < pr.getPos()) {
			return -1;
		}
		return 0;
	}
}