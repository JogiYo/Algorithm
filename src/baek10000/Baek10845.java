package baek10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek10845 {
	private Node front;
	private Node rear;
	int size = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Baek10845 queue = new Baek10845();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" "); 
			
			if(str[0].equals("push")) {
				queue.push(str[1]);
			}
			else if(str[0].equals("pop")) {
				if(queue.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else {
					bw.write(queue.pop() + "\n");
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
	
	public Baek10845() {
		this.front = null;
		this.rear = null;
	}
	
	public void push(Object data) {
		Node newNode = new Node(data);
		if(this.isEmpty()) {
			this.front = newNode;
			this.rear = newNode;
		}
		else {
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
			front = front.getNext();
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