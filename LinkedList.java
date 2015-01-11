package linkedList;

public class LinkedList {

	
	Node head;
	int numNodes = 0;
	
	LinkedList()
	{
		head = new Node();
	}
	void add(int data)
	{
		numNodes++;
		
		if(head.data == null)
		{
			head.data = data;
			head.next = null;
		}
		else
		{
			Node n = new Node(data);
			
			Node temp = head;
			
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			
			temp.next = n;
		}
	}
	
	void disp()
	{
		Node temp = head;
		
		System.out.print(numNodes);
		while(temp!=null)
		{
			System.out.print("["+temp.data+"]");
			temp = temp.next;
		}
	}
	
	int count(int n)
	{
		int count = 0;
		Node temp = head;
		
		while(temp!=null)
		{
			if(temp.data == Integer.valueOf(n))
				count++;
			temp = temp.next;
		}
		
		return count;
	}

	void insertSorted(int data)
	{
		Node temp = head;
		
		Node n = new Node(data);
		
		if(temp.data == null)
		{
			head = n;
			return;
		}
		else if((int)temp.data > data)
		{
			n.next = temp;
			head = n;
			return;
		}
		
		while(temp.next!=null && (int)temp.next.data < data)
		{
			temp = temp.next;
		}
		
		n.next = temp.next;
		temp.next = n;
		
		
	}
	
	void sort()
	{
		
		Node temp = head;
		
		LinkedList l1 = new LinkedList();
		
		while(temp!=null)
		{
			l1.insertSorted((int)temp.data);
			temp = temp.next;
		}
		
		this.head = l1.head;
		
	}
	
	static void append(LinkedList l1, LinkedList l2)
	{
		Node temp = l1.head;
		
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		
		temp.next = l2.head;
	}
	
	void split()
	{
		LinkedList fr = new LinkedList();
		LinkedList bk = new LinkedList();
		
		int	n = numNodes/2;
		boolean odd;
		
		if(numNodes%2 == 0)
			odd =false;
		else
			odd = true;
		
		Node temp = head;
		
		int i=0;
		if(odd)
		{
			while(temp!=null && i<n+1)
			{
				fr.add((int)temp.data);
				temp = temp.next;
				i++;
			}
			
			while(temp!= null)
			{
				bk.add((int)temp.data);
				temp = temp.next;
			}
		}
		else
		{
			while(temp!=null && i<n)
			{
				fr.add((int)temp.data);
				temp = temp.next;
				i++;
			}
			
			while(temp!= null)
			{
				bk.add((int)temp.data);
				temp = temp.next;
			}
		
			
		}
		
		System.out.println("Front : ");
		fr.disp();
		System.out.println();
		System.out.println("Back : ");
		bk.disp();
	}
	
	class Node
	{
		Node next = null;
		Object data = null;
		
		Node()
		{
			
		}
		
		Node(int data)
		{
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		ll.add(13);
		ll.add(12);
		ll.add(3);
		ll.add(2);
		ll.add(1);
/*
		ll.disp();
		//System.out.println("No. of times : "+ll.count(2));
		System.out.println();
		ll.insertSorted(11);
		ll.insertSorted(3);
		ll.insertSorted(6);
		ll.disp();
		ll.sort();
		ll.disp();*/
/*		
		LinkedList l1 = new LinkedList();
		
		l1.add(1);
		l1.add(6);
		l1.add(7);
		l1.add(8);
		
		append(ll,l1);
		ll.disp();*/
		
		ll.split();
		
	}

}
