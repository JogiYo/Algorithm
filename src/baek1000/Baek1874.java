package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Baek1874 {
	private Node topnode;
	int size = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr_temp = new ArrayList<Integer>();
		Baek1874 stk = new Baek1874();
		int n = Integer.valueOf(br.readLine()).intValue();
		
		for(int i = 0; i < n; i++) {
			arr.add(Integer.valueOf(br.readLine()).intValue());
		}

		for(int i = 0; i < n; i++) {
			arr_temp.add(arr.get(i));   // 비교를 위한  첫 배열
		}
		Collections.sort(arr);	        // 스택 push를 위한 배열 정렬
			
		while(!arr_temp.isEmpty()) {
			if(arr.contains(arr_temp.get(0))) {
				while(Integer.valueOf(arr_temp.get(0)).intValue() != Integer.valueOf(arr.get(0)).intValue()) {
					stk.push(arr.remove(0));
					bw.write("+\n");
				}
				stk.push(arr.remove(0));
				bw.write("+\n");
				stk.pop();
				bw.write("-\n");
				arr_temp.remove(0);
			}
			else {
				if(Integer.valueOf(arr_temp.get(0)).intValue() == Integer.valueOf((Integer)stk.peek()).intValue()) {
					stk.pop();
					bw.write("-\n");
					arr_temp.remove(0);
				}
				else {
					bw = new BufferedWriter(new OutputStreamWriter(System.out));
					bw.write("NO\n");
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public Baek1874() {
		this.topnode = null;
	}
	
	public void push(Object data) {
		Node newNode = new Node(data);
		newNode.setNext(topnode);
		topnode = newNode;
		size++;
	}
	
	public Object pop() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is Empty!");
		}
		else {
			Object data = this.peek();
			topnode = topnode.getNext();
			size--;
			return data;
		}
	}
	
	public Object peek() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return topnode.getData();
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return (topnode == null);
	}
}

class Node {
	private Object data;
	private Node next;
	
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setNext(Node node) {
		next = node;
	}
	
	public Node getNext() {
		return next;
	}
}