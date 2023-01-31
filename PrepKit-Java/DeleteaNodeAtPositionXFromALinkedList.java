public class DeleteaNodeAtPositionXFromALinkedList {
    
/* Linklist node structure
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/
class GfG
{
    Node deleteNode(Node head, int x)
    {
       Node temp = new Node(-1);
       temp.next=head;
       Node holder = temp;
	// Your code here
       int c=0;
      
       while (c!=x-1){
           temp= temp.next;
           c++;
       }
       temp.next = temp.next.next;
       return holder.next;
    }
}

}
