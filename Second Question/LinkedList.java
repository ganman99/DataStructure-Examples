
public class LinkedList {
    
    public Nodes head;
    public int  size;
    
    public LinkedList(){
        
        this.head   = null; 
        this.size   = 0; 
    }
    public boolean isEmpty(){
        
        return (this.head == null);
    }
    public void addNode(Nodes newNode){
      
      Nodes current = this.head;
      
      if(current == null){
          this.head = newNode;
          this.size++ ;
      }
      else{
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            this.size++ ;
      }
    }
    
    public void printList(){
        
        Nodes currNode = this.head;
    
        System.out.println("LinkedList: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(" {id:" + currNode.id + "   " + currNode.value + "}  --->");
    
            // Go to next node
            currNode = currNode.next;
        }
        System.out.println("");
          
    }
    
  
    
}
