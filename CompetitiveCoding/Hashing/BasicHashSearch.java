
class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{127,238,1635,14};
        int key = 24;
        int size = arr.length +1;
        int[] helper = new int[size];
        
        //insert
        for(int i = 0 ; i < size-1 ; i++) {
            int index = arr[i] % size;
            helper[index] = arr[i];
        }
        
        for(int x = 0 ; x < helper.length ; x++)
        System.out.print(helper[x] + " ");
       
        
        if(helper[key % size] == key ) System.out.println("Number found ");
        else System.out.println("Not Found");
    }
}
