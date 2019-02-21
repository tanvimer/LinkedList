public static void removeTheLoop(Node head)
{
     if (head == null || head.next == null) 
            return; 
   Node fast_ptr=head;
   Node slow_ptr=head;
   slow_ptr = slow_ptr.next; 
   fast_ptr = fast_ptr.next.next; 
    while(fast_ptr!=null && fast_ptr.next!=null){
        if(fast_ptr == slow_ptr) // condition for loop detection
        break;
        slow_ptr = slow_ptr.next;
        fast_ptr = fast_ptr.next.next;
    }
    if(slow_ptr == fast_ptr){
        
		//loop detected
        
		slow_ptr = head;
		
		
		/* Starting the slow pointer from head and fast pointer from the point of 
		intersection of slow and fast pointer and iterating both by one ,the meeting 
		point will bring us to the start of loop*/
        
		
		while(slow_ptr.next!=fast_ptr.next){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }
		
		// removing the loop by making the start of loop null
        
		fast_ptr.next = null;
    }
}