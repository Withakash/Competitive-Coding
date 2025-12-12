import java.util.Stack;

class Main {
    public static int[] NGE(int[] nums1,int[] nums2){
        int n = nums1.length;
        
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i-- )
        {
            while(!st.isEmpty() && st.peek() <= nums1[i])
            {
                st.pop();
            }
            if(st.isEmpty()) result[nums1[i]] = -1;
            else result[nums1[i]] = st.peek();
            
            st.push(nums1[i]);
        }
            for(int i = 0 ; i < nums2.length ; i++){
            or_result[i] = result[nums2[i]];
        }
          return or_result;
        }
    public static void main(String[] args) {
        
        int[] ar1 = {4,5,2,25};
        int[] ar2 = {4,2};
        int[] res = NGE(ar1,ar2);

        for(int x : res){
            System.out.print(x+" ");
        }
        
    }
}
