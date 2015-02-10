package linkedList;

import java.util.ArrayList;

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
		
		//System.out.print(numNodes);
		while(temp!=null)
		{
			System.out.print("["+temp.data+"]");
			temp = temp.next;
		}
		
		System.out.println();
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
	
	void remDup()
	{
		Node prt = head;
		Node t = head.next;
		int ar[] = new int[1000];
		
		ar[(int)prt.data]++;
		
		while(t!=null)
		{
			int data = (int)t.data;
			if(ar[data]==0)
			{
				ar[data]++;
				prt.next = t;
				prt = t;
				t = t.next;
			}
			else
			{
				t = t.next;	
			}
			
		}
	
		prt.next = t;

		
	}
	
	void MoveNode(LinkedList l1, LinkedList l2)
	{
		Node n = new Node((int)l2.head.data);
		
		if(l1.head.data!=null)
			n.next = l1.head;
		
		l1.head = n;
		
		l2.head = l2.head.next;
	}
	
	void altSplit()
	{
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		int i=0;
		
		Node temp = head;
		
		while(temp!=null)
		{
			if(i%2==0)
			{
				MoveNode(l1, this);
			}
			else
			{
				MoveNode(l2, this);
			}
			temp = temp.next;
			i++;
		}
		
		l1.disp();
		l2.disp();
	}
	
	void shufMerge(LinkedList l1, LinkedList l2)
	{
		Node temp1 = l1.head;
		Node temp2 = l2.head;
		
		int i=0;
		
		LinkedList l = new LinkedList();
		
		while(temp1!=null || temp2!=null)
		{
			if(temp1!=null && temp2!=null)
			{
				int data;
				
				if(i%2==0)
				{
					data = (int)temp1.data;
					temp1 = temp1.next;
				}
				else
				{
					data = (int)temp2.data;
					temp2 = temp2.next;
				}
				
				l.add(data);
				i++;
			}
			
			else
				if(temp1!=null)
				{
					l.add((int)temp1.data);
					temp1 = temp1.next;
				}
				else
					if(temp2!=null)
					{
						l.add((int)temp2.data);
						temp2 = temp2.next;
					}
		}
		
		l.disp();
	}
	
	void Merge(LinkedList l1, LinkedList l2)
	{
		Node temp1 = l1.head;
		Node temp2 = l2.head;
		
		if(temp1.data == null)
			temp1 = null;
		
		if(temp2.data == null)
			temp2 = null;
		
		LinkedList l = new LinkedList();
		
		while(temp1!=null || temp2!=null)
		{
			if(temp1!=null && temp2!=null)
			{
				int data;
				int d1 = (int)temp1.data;
				int d2 = (int)temp2.data;
				
				if(d1<d2)
				{
					data = d1;
					temp1 = temp1.next;
				}
				else
				{
					data = d2;
					temp2 = temp2.next;
				}
				
				l.add(data);
			}
			
			else
				if(temp1!=null)
				{
					l.add((int)temp1.data);
					temp1 = temp1.next;
				}
				else
					if(temp2!=null)
					{
						l.add((int)temp2.data);
						temp2 = temp2.next;
					}
		}
		
		l.disp();
	
		
	}
	
	void Inter(LinkedList l1, LinkedList l2)
	{
		//TODO
		Node temp1 = l1.head;
		Node temp2 = l2.head;
		
		if(temp1.data == null)
			temp1 = null;
		
		if(temp2.data == null)
			temp2 = null;
		
		LinkedList l = new LinkedList();
		
		while(temp1!=null || temp2!=null)
		{
			if(temp1!=null && temp2!=null)
			{
				int data;
				int d1 = (int)temp1.data;
				int d2 = (int)temp2.data;
				
				if(d1<d2)
				{
					data = d1;
					temp1 = temp1.next;
				}
				else
				{
					data = d2;
					temp2 = temp2.next;
				}
				
				l.add(data);
			}
			
			else
				if(temp1!=null)
				{
					l.add((int)temp1.data);
					temp1 = temp1.next;
				}
				else
					if(temp2!=null)
					{
						l.add((int)temp2.data);
						temp2 = temp2.next;
					}
		}
		
		l.disp();
	
		
	
	}
	
	//Recursive
	void revList()
	{
		Node temp = head;
		
		while(temp.next!=null)
			temp = temp.next;
		
		revList(head);
		
		head = temp;
	}
	
	void revList(Node n)
	{
		Node first;
		Node rest;
		
		if(n == null)
			return;
		
		first = n;
		rest = first.next;
		
		if(rest == null)
			return;
		
		revList(rest);
		
		first.next.next = first;
		first.next = null;
		
		//head = rest;
	}
	
	//iterative
	void revListIt()
	{
		Node current = head;
		Node prev = null;
		Node next = null;
		
		while(current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		
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
		
	/*	LinkedList ll = new LinkedList();
		
		ll.add(13);
		ll.add(13);
		ll.add(13);
		ll.add(3);
		ll.add(3);
		ll.add(2);
		ll.add(1);
		ll.add(2);
		ll.add(12);
		ll.disp();*/
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
		
		
		append(ll,l1);
		ll.disp();*/
		
		//ll.split();
		/*ll.remDup();
		ll.disp();*/
		
		/*LinkedList l1 = new LinkedList();
		
		l1.add(1);
		l1.add(6);
		l1.add(7);
		l1.add(8);
		l1.disp();
		
		ll.MoveNode(ll, l1);
		ll.disp();
		l1.disp();*/
		
		//ll.altSplit();
		
		LinkedList l1 = new LinkedList();
		
		l1.add(1);
		l1.add(3);
		l1.add(5);
		l1.add(6);
		l1.add(4);
		l1.add(2);
		l1.add(11);
		
		l1.disp();
		l1.revListIt();
		l1.disp();
		
	/*	LinkedList l2 = new LinkedList();
		
		l2.add(4);
		l2.add(6);
		l2.add(13);
		l2.add(20);*/
		
		//l1.shufMerge(l1, l2);
		//l1.Merge(l1, l2);
	}

}
