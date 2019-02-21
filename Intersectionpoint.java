class GFG
{
   
	int intersectPoint(Node headA, Node headB)
	{
	     // Make a Hashset to store the nodes being visited 
	     
		 HashSet<Node> visited = new HashSet<Node>();
         while(headA!=null){
             visited.add(headA);
             headA = headA.next;
         }
		 
		 /*find the already visited node in another linked list
		 that will be the point of intersection */ 
         
		 while(headB!=null){
             if(visited.contains(headB))
             return headB.data;
             else
             visited.add(headB);
             headB = headB.next;
         }
         return -1;
	}
}
