package Learn.HashSet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;



public class MyHashSet <T>{
	LinkedList <T>list = new LinkedList<T>();
	public  boolean put(T data) {
		if(list.contains(data)) {
			return false;
		}
		else 
		return	list.add(data);
	}
	public T get(T data) {
		if(list.contains(data)) {
			System.out.println("get data"+ data);
			return data;
		}else
			return null;
	}
	public void remove(T data) {
		if(list.contains(data)) {
			list.remove(data);
		}else
			System.out.println("不存在该元素");
	}
	public void printAll() {
		for(T t:list) {
			System.out.println(t);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MyHashSet<Integer> myHashSet =new MyHashSet<Integer>();
			myHashSet.put(111);
			myHashSet.put(222);
			myHashSet.put(333);
			myHashSet.get(333);
			myHashSet.remove(222);
			myHashSet.printAll();
	}

}
