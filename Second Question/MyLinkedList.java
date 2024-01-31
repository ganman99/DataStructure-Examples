

public class MyLinkedList {


    public static void main(String[] args) {
        
        Nodes n1 = new Nodes(0,4);
        Nodes n2 = new Nodes(1, 5);
        Nodes n3 = new Nodes(2,10);
        Nodes n4 = new Nodes(3,12);
        Nodes n5 = new Nodes(4,16);
        Nodes n6 = new Nodes(5, 25);
        Nodes n7 = new Nodes(6, 36);
        Nodes n8 = new Nodes(7, 37);
        Nodes n9 = new Nodes(8, 46);

        LinkedList L1 = new LinkedList();
        L1.addNode(n1);
        L1.addNode(n2);
        L1.addNode(n3);
        L1.addNode(n4);
        L1.addNode(n5);
        L1.addNode(n6);
        L1.addNode(n7);
        L1.addNode(n8);
        L1.addNode(n9);

        Nodes n10 = new Nodes(0,3);
        Nodes n11 = new Nodes(1, 6);
        Nodes n12 = new Nodes(2, 8);
        Nodes n13 = new Nodes(3, 9);
        Nodes n14 = new Nodes(4,18);
        Nodes n15 = new Nodes(5, 19);
        Nodes n16 = new Nodes(6, 45);
        Nodes n17 = new Nodes(7, 86);
        Nodes n18 = new Nodes(8, 95);

        LinkedList L2 = new LinkedList();
        L2.addNode(n10);
        L2.addNode(n11);
        L2.addNode(n12);
        L2.addNode(n13);
        L2.addNode(n14);
        L2.addNode(n15);
        L2.addNode(n16);
        L2.addNode(n17);
        L2.addNode(n18);
        
        
        LinkedList sortedList = listSorter(L1, L2);
        
        sortedList.printList();
        

    }



    public static LinkedList listSorter(LinkedList L1 , LinkedList L2){

        LinkedList newList = new LinkedList();
        Nodes currentL1 = L1.head;
        Nodes currentL2 = L2.head;
    

        
        int tempId = 0;
        


        while(newList.size < L1.size+L2.size){
            
            

            for(int i = 0 ; i<L2.size ; i++){

                
                
                
                try{   
                    if(currentL1.value < currentL2.value && currentL1 != null && currentL2 != null){
                        Nodes tempNode = new Nodes(tempId,currentL1.value);
                        
                        tempNode.id = tempId;
                        tempNode.value = currentL1.value;
                        newList.addNode(tempNode);
                        tempId++;
                        break;
                    }else if(currentL1.value > currentL2.value && currentL1 != null && currentL2 != null){
                        Nodes tempNode = new Nodes(tempId,currentL2.value);
                        
                        tempNode.id = tempId;
                        tempNode.value = currentL2.value;
                        newList.addNode(tempNode);
                        tempId++;
                    }else if(currentL1.value == currentL2.value && currentL1 != null && currentL2 != null){
                        System.out.println("THERE IS A EQUALİTY IN NodesS.");
                        Nodes tempNode = new Nodes(tempId,currentL1.value);
                        
                        tempNode.id = tempId;
                        tempNode.value = currentL1.value;
                        newList.addNode(tempNode);
                        tempId++;
                    }
                }catch(Exception e){
                    if(currentL1 == null){
                        while(newList.size < L1.size+L2.size){
                            Nodes tempNode = new Nodes(tempId,currentL2.value);
                            newList.addNode(tempNode);


                            currentL2 = currentL2.next;
                            tempId++;

                        }
                        break;
                    }else{
                        while(newList.size < L1.size+L2.size){
                            Nodes tempNode = new Nodes(tempId,currentL1.value);
                            tempId++;
                            newList.addNode(tempNode);
                            currentL1 = currentL1.next;
                            tempId++;
                        }
                        break;
                    }
                }
                currentL2 = currentL2.next;
            }
            if(currentL1 != null){    
                currentL1 = currentL1.next;
            }
        }


        return newList;

    }
    
    
}
