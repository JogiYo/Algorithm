package baek10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek10866 {
	private DNode front;
	private DNode rear;
	int size = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Baek10866 queue = new Baek10866();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" "); 
			
			if(str[0].equals("push_front")) {
				queue.push(str[1]);
			}
			else if(str[0].equals("push_back")) {
				queue.push_back(str[1]);
			}
			else if(str[0].equals("pop_front")) {
				if(queue.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(queue.pop() + "\n");
				}
			}
			else if(str[0].equals("pop_back")) {
				if(queue.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(queue.pop_back() + "\n");
				}
			}
			else if(str[0].equals("size")) {
				bw.write(queue.size()+"\n");
			}
			else if(str[0].equals("empty")) {
				if(queue.isEmpty()) {
					bw.write(1 + "\n");
				}
				else {
					bw.write(0 + "\n");
				}
			}
			else if(str[0].equals("front")) {
				if(queue.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(queue.peek() + "\n");
				}
			}
			else if(str[0].equals("back")) {
				if(queue.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(queue.rear() + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
	
	public Baek10866() {
		this.front = null;
		this.rear = null;
	}
	
	public void push(Object data) {
		DNode newNode = new DNode(data);
		if(this.isEmpty()) {
			this.front = newNode;
			this.rear = newNode;
		}
		else {
			front.setPrev(newNode);
			newNode.setNext(front);
			this.front = newNode;
		}
		size++;
	}
	
	public void push_back(Object data) {
		DNode newNode = new DNode(data);
		if(this.isEmpty()) {
			this.front = newNode;
			this.rear = newNode;
		}
		else {
			newNode.setPrev(rear);
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}
	
	public Object pop() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is Empty!");
		}
		else {
			Object data = this.peek();
			if(this.size() == 1) {
				front = null;
				rear = null;
			}
			else {
				front = front.getNext();
				if(front != null) {
					front.setPrev(null);
				}
			}
			size--;
			return data;
		}
	}
	
	public Object pop_back() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is Empty!");
		}
		else {
			Object data = this.rear();
			if(this.size() == 1) {
				front = null;
				rear = null;
			}
			else {
				rear = rear.getPrev();
				if(rear != null) {
					rear.setNext(null);
				}
			}
			size--;
			return data;
		}
	}
	
	public Object peek() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return front.getData();
		}
	}
	
	public Object rear() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return rear.getData();
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
}
class DNode {
	private Object data;
	private DNode next;
	private DNode prev;
	
	public DNode(Object data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setNext(DNode node) {
		next = node;
	}
	
	public DNode getNext() {
		return next;
	}
	
	public void setPrev(DNode node) {
		prev = node;
	}
	
	public DNode getPrev() {
		return prev;
	}
}