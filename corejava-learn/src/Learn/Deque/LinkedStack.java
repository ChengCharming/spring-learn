package Learn.Deque;

import java.util.LinkedList;

public class LinkedStack {
	LinkedList linked = new LinkedList();

	public void push(Object s) {
		linked.addLast(s);
	}

	public void push(int s) {
		linked.addLast(s);
	}

	public void pop() {
		if (linked.isEmpty()) {
			System.out.println("栈中缺少元素");
		} else {
			linked.remove(linked.size() - 1);
		}
	}

	public void peek() {
		if (linked.isEmpty()) {
			System.out.println("栈中缺少元素");
		} else {
			System.out.println(linked.get(linked.size() - 1));
		}
	}

	public LinkedStack(LinkedList linked) {
		super();
		this.linked = linked;
	}

	public static void main(String[] args) {
		LinkedList linked = new LinkedList();
		LinkedStack stack = new LinkedStack(linked);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		stack.peek();

	}

}
