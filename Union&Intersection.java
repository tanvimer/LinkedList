import java.util.*;
class Node {
  int data;
  Node next;
    Node (int d){
    data = d;
    next = null;
  }
}
class Pair {
  int count;
  int ind;
  public Pair (int count, int ind) {
    this.count = count;
    this.ind = ind;
  }
}

public class LinkedList {
  Node head;
  public void push (int new_data) {
    Node new_node = new Node (new_data);
      new_node.next = head;
      head = new_node;
  }
  public void intersectionAndUnion (Main list1, Main list2){
    
	Node temp1 = list1.head;
    Node temp2 = list2.head;
	Map < Integer, Pair > map = new LinkedHashMap < Integer, Pair > ();

    while (temp1 != null || temp2 != null) {

	 if (temp1 != null){
	    if (map.containsKey (temp1.data) && map.get (temp1.data).ind != 1)
	      map.put (temp1.data,new Pair (map.get (temp1.data).count + 1, 1));
	    else
	      map.put (temp1.data, new Pair (1, 1));
	    
		temp1 = temp1.next;
	  
	  }

	if (temp2 != null){
	    
		if (map.containsKey (temp2.data) && map.get (temp2.data).ind != 2)
	        map.put (temp2.data,new Pair (map.get (temp2.data).count + 1, 2));
	    else
	  		map.put (temp2.data, new Pair (1, 2));
	  
    	temp2 = temp2.next;
	  }
    }
    head = null;
    Node head1 = null, res = null;
    for (Map.Entry < Integer, Pair > entry:map.entrySet ())  {
		int x = entry.getValue ().count;
		Node nn = new Node (entry.getKey ());
		if (head1 == null) {
			head1 = nn;
			res = nn;
		}
		else {
			nn.next = head1;
			head1 = nn;
			res = head1;
		}
		if (x > 1) 
	    push (entry.getKey ());
    }
    System.out.println ("Union");
   
   while (res != null)
    {
		System.out.print (res.data + " ");
		res = res.next;
    }
  }
  public static void main (String args[]) {

    Scanner sc = new Scanner (System.in);
    
    LinkedList list1 = new LinkedList ();
    int n1 = sc.nextInt ();
	for (int i = 0; i < n1; i++)
      list1.push (sc.nextInt ());
	  
    LinkedList list2 = new LinkedList ();
    int n2 = sc.nextInt ();
    for (int i = 0; i < n2; i++)
      list2.push (sc.nextInt ());
	  
    list1.intersectionAndUnion (list1, list2);
    System.out.println ("Intersection");
    
	while (list1.head != null) {
		System.out.print (list1.head.data + " ");
		list1.head = list1.head.next;
    }
  }
}
