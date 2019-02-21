import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d)
        { 
               data = d; 
               next = null;
         }
    }
public class FindMiddle
{
    Node head;  
    public void addToTheLast(Node node) {
		if (head == null) 
			head = node;
		else {
			Node temp = head;
				while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}
	  
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(); 
		while(t>0)
         {
			int n = sc.nextInt();
			FindMiddle llist = new FindMiddle();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
          
        FindMiddle obj = new FindMiddle(); 
		System.out.println(obj.getMiddle(llist.head));
		t--;
		}
	}
    int getMiddle(Node head)
	{
        Node fast_ptr=head;
        Node slow_ptr = head;
        while(fast_ptr!=null && fast_ptr.next!=null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr.data;
   }
}