
import java.util.LinkedList;
@SuppressWarnings("unchecked")
class HashTable {
      int size;
      LinkedList<Integer>[] tab;
      
      HashTable(int size)  {
          this.size = size;
          tab = (LinkedList<Integer>[]) new LinkedList[size];
          
          for(int i = 0 ; i < size ; i++) {
              tab[i] = new LinkedList<>();
          }
      }
      
      int getIndex(int key) {
          return key % size ; 
      }
     
      void insert(int key) {
          int index = getIndex(key);
          tab[index].add(key);
          
          System.out.println(key + " inserted at index : " + index);
      }
      
      void search(int key) {
          int index = getIndex(key);
          if(tab[index].contains(key))
           System.out.println(tab[index] + " : Value available at key -> " + index);
          else 
           System.out.println("Not found");
      }
      
      void print() {
        for(int i = 0; i < size; i++) {

            System.out.print(i + " -> ");

            for(int x : tab[i])
                System.out.print(x + " ");

            System.out.println();
        }
      }
    
     
    public static void main(String[] args) {
      HashTable tab = new HashTable(10);
      tab.insert(10);
      tab.insert(20);
      tab.insert(22);
      tab.insert(28);
      tab.insert(11);
      
      tab.search(30);
      System.out.println();
      tab.print();
      
      
    }
}
