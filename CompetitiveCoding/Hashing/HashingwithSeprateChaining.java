
import java.util.*;
@SuppressWarnings("unchecked")

class BasicHash {
     int size;
     LinkedList<Integer>[] table;
     
     BasicHash(int s) {
         size = s;
         table = (LinkedList<Integer>[]) new LinkedList[size];
         for(int i = 0 ; i < size ; i++)
             table[i] = new LinkedList<>();
     }
     
     int getIndex(int key) {
         return key % size;
     }
     
     void insert(int key) {
         int index = getIndex(key);
         table[index].add(key);
         
        //  System.out.println(index + " -> " + key);
     }
     
     
     void print() {
         for(int i = 0 ; i < size ; i++) {
             System.out.print(i + " -> ");
               for(int x : table[i]) {
                  System.out.print(x + " ");                   
               }
               System.out.println();
         }
     }
     
     
     void search(int key) {
         int index = getIndex(key);
         if(table[index].contains(key))
           System.out.print("Haaa " + key + " Mil Gya !!");
         else 
           System.out.println("Nahi mila" );
     }
     
     
    
    public static void main(String[] args) {
        BasicHash hash = new BasicHash(10);
        int[] arr = new int[]{22,100,37,59,118};
        
        for(int i : arr)
          hash.insert(i);
          hash.insert(35);
          hash.insert(75);
          hash.insert(75);
          hash.insert(25);
          hash.insert(45);
          hash.insert(55);
          hash.insert(78);
          hash.print();
          hash.search(25);
    }
    
     
}
