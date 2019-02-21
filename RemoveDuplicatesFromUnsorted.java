class LinkedList
{
    Node removeDuplicates(Node head)
    {
        Node temp1=head;
        Node res=null,ress=null;
        int count[] = new int[1000];
       
        while(temp1!=null){
            count[temp1.data]++;
            if(count[temp1.data] == 1)
            {
                if(res == null){
                    res=temp1;
                    ress=res;
                }
                else{
                    res.next=temp1;
                    res = res.next;
                }    
            }
            temp1 = temp1.next;
        }
        res.next=null;
        return ress;
    }
}
