
import java.util.*;
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
    


    List<List<Integer>> al = new ArrayList<>();
    List<List<Integer>> levelorder(Node root) {
        if(root == null) return al;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size ;
        while(!q.isEmpty()) {
             size = q.size();
             ArrayList<Integer> level = new ArrayList<>();
            for(int i =0 ; i < size ; i++) {
              Node curr = q.poll();
              level.add(curr.data);
              if(curr.left != null) q.add(curr.left);
              if(curr.right != null) q.add(curr.right);
           }
           al.add(level);
        }
        return al;
     }
    
    
    int depthofBST(Node root) {
        int depth = 0;
        if(root == null) return depth;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size;
        while(!q.isEmpty()) {
            size = q.size();
            
            for(int i =0 ; i < size ; i++) {
                Node curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            depth++;
        }
        
        return depth;
    }
    
    
        List<Integer> lv = new ArrayList<>();
        List<Integer> leftView(Node root) {
        if(root == null) return lv;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size ;
        while(!q.isEmpty()) {
             size = q.size();
            for(int i =0 ; i < size ; i++) {
              Node curr = q.poll();
              if(i == 0) lv.add(curr.data);
              if(curr.left != null) q.add(curr.left);
              if(curr.right != null) q.add(curr.right);
            }
        }
        return lv;
     }
     
     
     List<Integer> rv = new ArrayList<>();
        List<Integer> rightView(Node root) {
        if(root == null) return rv;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size ;
        while(!q.isEmpty()) {
             size = q.size();
            for(int i =0 ; i < size ; i++) {
              Node curr = q.poll();
              if(i == size-1) rv.add(curr.data);
              if(curr.left != null) q.add(curr.left);
              if(curr.right != null) q.add(curr.right);
            }
        }
        return rv;
     }
    
    
    

    
    public static void main(String[] args) {
       BST bstree = new BST();
       bstree.insert(10);
       bstree.insert(5);
       bstree.insert(20);
       bstree.insert(2);
       bstree.insert(7);
       bstree.insert(15);
       bstree.insert(25);
       bstree.insert(1);
       bstree.insert(13);
       bstree.insert(11);
       bstree.insert(12);
       System.out.println();
      bstree.preorder(bstree.root);
      System.out.println("Preorder");
      bstree.inorder(bstree.root);
      System.out.println("Inorder");
      bstree.postorder(bstree.root);
      System.out.println("Postorder");
    
        List<List<Integer>> res = bstree.levelorder(bstree.root);
         System.out.println(res + " : Level Order");
         
         int hb = bstree.depthofBST(bstree.root);
         System.out.println("Depth of BST : "+hb);
         
         
         List<Integer> leftview = bstree.leftView(bstree.root);
         System.out.println("Left View of BST : "+leftview);
         
         List<Integer> rightview = bstree.rightView(bstree.root);
         System.out.println("Right View of BST : "+rightview);
 
    }
}
