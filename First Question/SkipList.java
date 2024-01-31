



public class SkipList {
    
    public Node head;
    public int  size;
    
    public SkipList(){
        
        this.head   = null; 
        this.size   = 0; 
    }

    public boolean isEmpty(){
        return (this.head == null);
    }

    public void addNode(Node newNode){
        Node current = this.head;
      
        if(current == null){
          this.head = newNode;
          this.size++ ;
        }
        else{
            while(current.thirdnext != null){

                if(current.firstNext != null){
                    current = current.firstNext;
                }else if(current.secondNext != null){
                    current = current.secondNext;
                }else{
                    current = current.thirdnext;
                }
            }
            if(newNode.id % 4 == 0 && !(newNode.id < 0)){
                searchNode(newNode.id - 4).firstNext=newNode;
            }
            if(newNode.id  % 2 == 0 && !(newNode.id < 0)){
                searchNode(newNode.id -2).secondNext = newNode;
            }
            System.out.println("");
            current.thirdnext = newNode;
            this.size++ ;
        }

        

    }

    public Node searchNode(int id){

        Node temp = this.head;

        while(id > temp.id){
            if(id - temp.id >= 4){
                temp = temp.firstNext;
            }else if(id - temp.id >=2 ){
                temp = temp.secondNext;
            }else{
                temp = temp.thirdnext;
            }
        }
        return temp;
    }
    public Node searchNodeLikeSingleList(int id){

        Node temp = this.head;

        while(id > temp.id){
            temp = temp.thirdnext;
        }
        return temp;
    }

    public void printList(){
        
        Node currNode = this.head;
    
        System.out.println("SkipList: ");
    
        
        while (currNode != null) {
            
            System.out.print(" {id:" + currNode.id + "   " + currNode.name + "}  --->");
    
            
            currNode = currNode.thirdnext;
        }
        System.out.println("");
          
    }


    public void printNode(){
        Node currNode = this.head;
    
        System.out.println("SkipList and nodes` pointers");
    
        
        while (currNode != null) {
            
            System.out.print(currNode.id +" ");
            if(!(currNode.secondNext == null)){
                System.out.print(currNode.id +" ");
            }
            if(!(currNode.firstNext == null)){
                System.out.print(currNode.id +" ");
            }
            
            System.out.println("");
            
            currNode = currNode.thirdnext;
        }
        System.out.println("");
    }
    
  
    
}
