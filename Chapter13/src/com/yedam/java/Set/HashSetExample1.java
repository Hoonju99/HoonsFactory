package com.yedam.java.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("SServlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체 수 : " + size);
		
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) { //-------->  한번씩은 꼭 나오게 중첩되지 않게
			String element = iterator.next();
			System.out.println(element);
			
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체 수 " + set.size());
		
		for(String element : set) {
			System.out.println(element);
		}
		
		set.clear();
		if(set.isEmpty()) {
			System.out.println("비어있음");
		}
		
		
	}

}
