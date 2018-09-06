package Learn.Deque;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayDeque {
	ArrayList array = new ArrayList();

	public void push(Object s) {
		array.add(s);
	}

	public void pushFirst(Object s) {
		array.add(0, s);
	}

	public void pushLast(Object s) {
		array.add(array.size() - 1, s);
	}

	public void popFirst() {
		if (array.isEmpty()) {
			System.out.println("队列中没有元素");
		} else {
			System.out.println(array.get(0));
			array.remove(0);
		}
	}

	public void popLast() {
		if (array.isEmpty()) {
			System.out.println("队列中没有元素");
		} else {
			System.out.println(array.get(array.size() - 1));
			array.remove(array.size() - 1);
		}

	}

	public void peekFirst() {
		System.out.println(array.get(0));
	}

	public void peekLast() {
		System.out.println(array.get(array.size() - 1));
	}

	public ArrayDeque(ArrayList array) {
		super();
		this.array = array;
	}

	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		ArrayDeque deque = new ArrayDeque(array);

		deque.push("a");
		deque.push("b");
		deque.push("c");
		deque.push("d");
		deque.popFirst();
		deque.popFirst();
		deque.popLast();
		Iterator it = array.iterator();
		System.out.println("==================");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
