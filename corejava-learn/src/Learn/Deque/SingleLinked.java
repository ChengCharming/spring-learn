package Learn.Deque;

public class SingleLinked <T>{
	public Link<T> head;
	public SingleLinked() {
		
	}
	public boolean isEmpty() {
		return head == null;
	}
	public T getHead() {
		if(isEmpty())return null;
		else
			return head.data;
	}
	public void insert(T data) {
		Link<T> newLink= new Link<T>(data);
		if(isEmpty()) {
			head=newLink;
		}
		else{
			newLink.next=head;
		}
		head=newLink;
	}
	public void printAll() {
		if(isEmpty()) {
			System.out.println("空");
		}else
		{
			Link<T> temp = head;
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
	}
	public boolean delete() {
		if(isEmpty()) {
			return false;
		}
		Link<T> temp = head;
		head=head.next;
		temp.next=null;
		return true;
	}
	public T find(T data) {
		if(isEmpty()) {
			return null;
		}
		Link<T> temp = head;
		while(!temp.data.equals(data)) {
			temp=temp.next;
		}
		if(temp == null) {
			return null;
		}
		return temp.data;
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinked <Integer> list =new SingleLinked();
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		list.delete();
		System.out.println(list.getHead());
		System.out.println("====================");
	
		list.printAll();
	}

	class Link<T>{
		public T data;
		public Link<T> next;
		public Link(T data) {
			this.data=data;
		}
	}
}
