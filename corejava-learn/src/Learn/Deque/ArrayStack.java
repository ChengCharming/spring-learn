package Learn.Deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayStack {
	ArrayList array = new ArrayList();

	public void push(Object s) {
		array.add(s);
	}

	public void push(int s) {
		array.add(s);
	}

	public void pop() {
		if (array.isEmpty()) {
			System.out.println("栈中缺少元素");
		} else {
			array.remove(array.size() - 1);
		}
	}

	public void peek() {
		if (array.isEmpty()) {
			System.out.println("栈中缺少元素");
		} else {
			System.out.println(array.get(array.size() - 1));
		}
	}

	public ArrayStack(ArrayList<String> array) {
		this.array = array;
	}

	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		ArrayStack stack = new ArrayStack(array);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push(4);
		stack.pop();
		stack.pop();
		stack.peek();

	}

}
