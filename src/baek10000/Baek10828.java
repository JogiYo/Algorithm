package baek10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek10828 {
	private Node topnode;
	int size = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Baek10828 stk = new Baek10828();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" "); 
			
			if(str[0].equals("push")) {
				stk.push(str[1]);
			}
			else if(str[0].equals("pop")) {
				if(stk.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(stk.pop() + "\n");
				}
			}
			else if(str[0].equals("size")) {
				bw.write(stk.size()+"\n");
			}
			else if(str[0].equals("empty")) {
				if(stk.isEmpty()) {
					bw.write(1 + "\n");
				}
				else {
					bw.write(0 + "\n");
				}
			}
			else if(str[0].equals("top")) {
				if(stk.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(stk.peek() + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
	
	public Baek10828() {
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