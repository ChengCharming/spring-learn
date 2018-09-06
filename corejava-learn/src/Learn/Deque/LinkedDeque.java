package Learn.Deque;

import java.util.LinkedList;

public class LinkedDeque {
LinkedList linked =new LinkedList();
public void push(Object s) {
	linked.add(s);
}
public void pushFirst(Object s) {
	linked.addFirst(s);
}
public void pushLast(Object s) {
	linked.addLast(s);
}

	public LinkedDeque(LinkedList linked) {
	super();
	this.linked = linked;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linked =new LinkedList();
		LinkedDeque deque= new LinkedDeque(linked);
		deque.push(2);
	}

}
