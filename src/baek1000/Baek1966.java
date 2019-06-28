package baek1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1966 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case-- > 0) {
			String[] str = br.readLine().split(" ");
			int doc_count = Integer.parseInt(str[0]);
			int find_doc = Integer.parseInt(str[1]);
			
			Queue<Document> queue = new LinkedList<Document>();
			String[] impo = br.readLine().split(" ");
			for(int i = 0; i < doc_count; i++) {
				Document dc = new Document(i, Integer.parseInt(impo[i]));
				queue.offer(dc);
			}
			
			boolean flag = false;
			int result = 1;
			
			while(!flag) {
				while(!flag) {
					flag = checkImportance(queue);
				}
				flag = false;
				if(queue.poll().getSequence() == find_doc) {
					flag = true;
					bw.write(result + "\n");
				}
				else result++;
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	private static boolean checkImportance(Queue<Document> queue) {
		for(int i = 1; i < queue.size(); i++) {
			if(queue.peek().getImportance() < ((LinkedList<Document>)queue).get(i).getImportance()) {
				queue.offer(queue.poll());
				return false;
			}
		}
		return true;
	}
}

class Document {
	private int sequence;
	private int importance;
	
	Document(int sequence, int importance) {
		this.sequence = sequence;
		this.importance = importance;
	}
	
	public int getSequence() {
		return this.sequence;
	}
	
	public int getImportance() {
		return this.importance;
	}
}