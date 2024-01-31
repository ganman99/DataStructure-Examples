

public class Node {
    
    public int id;
    public String name;
    public Node thirdnext;
    public Node secondNext;
    public Node firstNext;
    
    
    
    public Node(int id, String name){
        this.id     = id;
        this.name   = name;
        this.thirdnext   = null;
        this.secondNext = null;
        this.firstNext = null;
    }
    
    
    
}
