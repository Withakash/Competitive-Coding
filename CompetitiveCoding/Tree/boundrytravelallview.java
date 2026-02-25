
import java.util.*;
import java.util.Stack;
class BST {
    Node root = null;
    static class Node {
        int data;
        Node left,right;
        
        Node(int val) {
            data = val;
            left = null;
            right = null;
            // System.out.println(data+" : Constructor ");
        }
    }
    
    Node insert(int val) {
        Node new_node = new Node(val);
        
        if(root == null) {
            root = new_node;
            return root;
        }
        
        Node curr = root;
        while(curr != null) {
            if(val < curr.data && curr.left != null) {
                curr = curr.left;
            }
            else if(val > curr.data && curr.right != null) {
                curr = curr.right;
            }
            else break;
        }
        if(val < curr.data) {
            curr.left = new_node;
        }
        else {
            curr.right = new_node;
        }
        
        return root;
        
    }
    
    void preorder(Node root) {
        
        if(root == null) return;
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
        
    }
    
    void inorder(Node root) {
        if(root == null) return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    void postorder(Node root) {
        if(root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    void boundrytravel(Node root) {
       if(root == null) return;
       
    //   TOP VIEW
      System.out.print(root.data + " " );
       
       
    //   LEFT VIEW
      leftview(root);
       
      //BOTTOM VIEW 
      bottomview(root);
    
     //RIGHT VIEW
    
          rightview(root);
       
   }
   
   boolean isLeaf(Node root) {
       if(root.left == null && root.right == null) return true;
       return false;
   }
   
   void leftview(Node root) {
       Node curr = root.left;
       
       while(curr != null){
           
            if(!isLeaf(curr))
          System.out.print(curr.data + " ");
           if(curr.left != null) curr = curr.left;
           else curr = curr.right;
       }
   }
   
   void bottomview(Node root) {
       if(root == null) return;
       
       if(isLeaf(root))
      System.out.print(root.data + " ");
       bottomview(root.left);
       bottomview(root.right);
   }
   
   void rightview(Node root) {
       Node curr = root.right;
       
       Stack<Integer> st = new Stack<>();
       
       while(curr != null) {
           if(!isLeaf(curr))
          st.push(curr.data);
          if(curr.right != null) curr = curr.right;
          else curr = curr.left;
       }
       
       while(!st.isEmpty()) {
           System.out.print(st.pop() + " ");
       }
       
   }
    
    

    
    public static void main(String[] args) {
       BST bstree = new BST();
       bstree.insert(10);
       bstree.insert(5);
       bstree.insert(15);
       bstree.insert(2);
       bstree.insert(7);
       bstree.insert(12);
       bstree.insert(20);
       bstree.insert(3);
      bstree.insert(4);
      bstree.insert(30);
      bstree.insert(40);
      bstree.insert(50);
    //   bstree.insert(-3);
       
       System.out.println();

        bstree.boundrytravel(bstree.root);
        //  System.out.println(boundry);

 
    }
}
