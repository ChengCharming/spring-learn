package Learn.Deque;

import Learn.Deque.DoublyLinkedList.Link;

public class NodeLinked<T> {
	private Link<T> head;
	private Link<T> rear;

	public NodeLinked() {

	}

	public T peekHead() {
		if (head != null)
			return head.data;
		return null;
	}

	public T peekRear() {
		if (rear != null)
			return rear.data;
		return null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertFirst(T data) {
		Link<T> newLink = new Link<T>(data);
		if (isEmpty()) {
			rear = newLink;
		} else {
			head.previous = newLink;
		}
		newLink.next = head;
		head = newLink;
	}

	public void insertLast(T data) {
		Link<T> newLink = new Link<T>(data);
		if (isEmpty()) {
			head = newLink;
		} else {
			rear.next = newLink;
		}
		newLink.previous = rear;
		rear = newLink;
	}

	public T deleteHead() {
		if (isEmpty())
			return null;
		Link<T> temp = head;
		head = head.next;
		if (head != null) {
			head.previous = null;
		} else {
			rear = null;
		}
		return temp.data;
	}

	public T deleteRear() {
		if (isEmpty())
			return null;
		Link<T> temp = rear;
		rear = rear.previous;
		if (rear != null) {
			rear.next = null;
		} else {
			head = null;
		}
		return temp.data;
	}

	public T find(T t) {
		if (isEmpty())return null;
		Link<T> find = head;
		while (find != null) {
			if (!find.data.equals(t))
				find = find.next;
			else
				break;
		}
		if (find == null) {
			return null;
		}
		return find.data;

	}

	public T delete(T t) {
		if (isEmpty()) {
			return null;
		}
		Link<T> current = head;
		while (!current.data.equals(t)) {
			current = current.next;
			if (current == null) {
				return null;
			}
		}
		if (current == head) {
			head = head.next;
			if (head != null) {
				head.previous = null;
			}
		} else if (current == rear) {
			rear = rear.previous;
			if (rear != null) {
				rear.next = null;
			}
		} else {
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		return current.data;

	}

	public void displayList4Head() {
		System.out.println("List:head-->rear");
		Link<T> current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public void displayList4Rear() {
		System.out.println("List:rear-->head");
		Link<T> current = rear;
		while (current != null) {
			System.out.println(current.data);
			current = current.previous;
		}
	}

	public boolean insertAfter(T k, T data) {
		if (isEmpty()) {
			return false;
		}
		Link<T> current = head;
		while (!current.data.equals(k)) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		Link<T> newLink = new Link<T>(data);
		if (current == head) {
			newLink.next = current.next;
			current.next.previous = newLink;
			newLink.previous = current;
			current.next = newLink;
		} else if (current == rear) {
			newLink.next = null;
			rear = newLink;
			current.next = newLink;
			newLink.previous = current;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
			current.next = newLink;
			newLink.previous = current;
		}
		return true;
	}

	public static void main(String args[]) {
		NodeLinked<Integer> list = new NodeLinked<Integer>();
		list.insertLast(1);
		list.insertFirst(2);
		list.insertLast(3);
		list.insertFirst(4);
		list.insertLast(5);
		list.displayList4Head();
		
 
		Integer deleteHead = list.deleteHead();
		System.out.println("deleteHead:" + deleteHead);
		list.displayList4Head();
		
		Integer deleteRear = list.deleteRear();
		System.out.println("deleteRear:" + deleteRear);
		list.displayList4Rear();
		
		System.out.println("find:" + list.find(6));
		System.out.println("find:" + list.find(3));
 
		System.out.println("delete find:" + list.delete(6));
		System.out.println("delete find:" + list.delete(1));
		list.displayList4Head();
		
		System.out.println("----在指定key后插入----");
		list.insertAfter(2, 8);
		list.insertAfter(2, 9);
		list.insertAfter(9, 10);
		list.displayList4Head();
	}

	class Link<T> {
		T data;
		Link<T> next;
		Link<T> previous;

		public Link(T data) {
			this.data = data;
		}

		void displayLink() {
			System.out.println("this link is:" + data.toString());
		}
	}
}
