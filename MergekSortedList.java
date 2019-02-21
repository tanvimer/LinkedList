class GfG
{
    PriorityQueue<Node> min = new PriorityQueue<Node>(new Comparator<Node>(){
        public int compare(Node x , Node y){
            return x.data - y.data;
        }
    } );
    Node mergeKList(Node[]a,int N)
    {
      Node res=null,curr=null;
      for(Node i:a)
      min.add(i);
      while(min.isEmpty() == false){
          Node temp = min.poll();
          if(temp.next != null)
          min.add(temp.next);
          if(res == null){
              res = temp;
              curr = temp;
          }
          else{
              curr.next = temp;
              curr = curr.next;
          }
      }
      return res;
    }
}