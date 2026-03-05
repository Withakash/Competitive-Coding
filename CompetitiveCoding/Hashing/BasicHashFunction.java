
class HashTable {
      int size;
      int[] tab;
      
      HashTable(int size)  {
          this.size = size;
          tab = new int[size];
      }
      
      int getIndex(int key) {
          return key % size ; 
      }
     
      void insert(int key, int value) {
          int index = getIndex(key);
          tab[index] = value;
          System.out.println(value + " inserted at index : " + index);
      }
      
      void search(int key) {
          int index = getIndex(key);
          System.out.println(tab[index] + " : Value available at key -> " + key);
      }
      
      void print() {
          for(int i : tab) 
           System.out.print(i + " ");
      }
    
     
    public static void main(String[] args) {
      HashTable tab = new HashTable(10);
      tab.insert(10,2222);
      tab.insert(22,3333);
      tab.insert(28,4444);
      tab.insert(11,5555);
      
      tab.search(11);
      System.out.println();
      tab.print();
      
      
    }
}
