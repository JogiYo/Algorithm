package baek4000;

import java.util.ArrayList;
import java.util.Iterator;

public class Baek4673 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		for(int i = 1; i < 10000; i++) {
			list.add(i);
		}
		
		for(int i = 1; i < 10000; i++) {
			if(list.indexOf(dn(i))!= -1) {
				list.remove(list.indexOf(dn(i)));
			}
		}
		
		Iterator<Integer> ie = list.iterator();
		
		while(ie.hasNext()) {
			System.out.println(ie.next());
		}
	}
	
	private static int dn(int n) {
		int thou,hund,ten,sin,result;
		thou = n/1000;
		hund = (n-thou*1000)/100;
		ten = (n-thou*1000-hund*100)/10;
		sin = n%10;
		result = n + thou + hund + ten + sin;
		
		return result;
	}
}
