

public class HashTable{


    String[] str;
    int maxSize;
    int fullness = 0;

    public HashTable(int arraySize){

        str = new String[arraySize];
        maxSize = arraySize;
    }



    public void addElement(String strValue){
        
        int indx = hash(strValue);

        if(indx != 444555){
            if(this.fullness < this.maxSize){
                while(this.str[indx] != null){
                    if(indx == this.maxSize){
                        indx = 0;
                        break;
                    }
                    indx++;
                }
                this.str[indx] = strValue;
                fullness++;
            }else{
                System.out.println("Hash table is full.Program cannot add. ");
            }
        }else{
            System.out.println("There is an invalid number in begining of string.");
        }        
    }

    public int hash(String strValue){
        
        int last;
        if(strValue.charAt(0) < 123 && strValue.charAt(0) > 96){
            last = strValue.charAt(0) - 96;
        }else if(strValue.charAt(0) < 91 && strValue.charAt(0) > 64){
            last = strValue.charAt(0) - 64;
        }else{
            last = 444555;
        }
        return last;
        
    }




    public void mostRepeated(){

        String[] mostRepeatedWords = new String[this.maxSize];
        int[] repeatness = new int[this.maxSize];
        

        for(int i = 0 ; i<this.str.length ; i++){
            
            for(int j =0; j<this.str.length ; j++){
                if(this.str[i] == this.str[j] && this.str[j] != null){
                    mostRepeatedWords[i] = this.str[i];
                    repeatness[i]++;
                    
                    
                }
            }
            
        }
        
        int indexOfMax = 0;
        int maxRepeatness = 0;

        for(int i = 0 ; i<repeatness.length ; i++){
            if(maxRepeatness < repeatness[i]){
                indexOfMax = i;
                maxRepeatness = repeatness[i];
            }
            
        }
        System.out.println("Most repated word is "+mostRepeatedWords[indexOfMax]);
        
    }

    public void distinctWord(){

        int distinctWords = 0;
        int thing = 0;
        


        for(int i = 0 ; i<this.str.length ; i++){
            thing = 0;
            for(int j = 0 ; j<this.str.length ; j++){

                if(this.str[i] != null && null != this.str[j]){
                    if(this.str[i].length() == this.str[j].length()){
                        if(thing == 1){
                            break;
                        }
                        thing++;
                    }
                }

                if(j == this.str.length-1 && this.str[i] != null){
                    
                    distinctWords++;
                }
            }
        }
        System.out.println("The number whose word length is different from the others is "+distinctWords+" types");


    }



}

