

public class HashEx{

    public static void main(String[] args){

        HashTable myHash = new HashTable(30);

        myHash.addElement("Ord.Prof.AbuzerKömürcü");
        myHash.addElement("Berk");
        myHash.addElement("Kocamanoğlu");
        myHash.addElement("Random");
        myHash.addElement("Things");
        myHash.addElement("Berk");
        myHash.addElement("Berk");
        myHash.addElement("Kocamanoğlu");
        myHash.addElement("HomeworkIsDone");
        myHash.addElement("VordLordemort");
        myHash.mostRepeated();
        myHash.distinctWord();
        
     }

}