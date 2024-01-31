

public class MySkipList {


    public static void main(String[] args) {
        
        Node n1 = new Node(0, "Node 1");

        
        SkipList myList = new SkipList();
        
        
        myList.addNode(n1);
        for(int i = 1; i < 301; i++){    
            Node newNode = new Node(i,"Node " + (i+1));
            myList.addNode(newNode); 
        }
        System.out.println("-----------------------------------------------------------------------");
        myList.printNode();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");

        long time1 = System.nanoTime();
        Node tempNode = myList.searchNodeLikeSingleList(300);
        long time2 = System.nanoTime();
        System.out.println("Spent time when linked list searchs:"+(time2-time1));

        long time3 = System.nanoTime();
        Node tempNode1 = myList.searchNode(300);
        long time4 = System.nanoTime();
        System.out.println("Spent time when skip list searchs: "+(time4-time3));
        

    }
    
}
