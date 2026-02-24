
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
    
    List<List<Integer>> res = new ArrayList<>();
    
    List<List<Integer>> levelorder(Node root) {
        int count = 0;
        if(root == null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> level = new ArrayList<>();
            
            for(int i =0 ; i < size ; i++) {
            Node curr = q.poll();
            level.add(curr.data);
            // System.out.print(curr.data +  " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            }
            
            res.add(level);
            count++;

        }
        System.out.println("Height of BST : " + count);
        return res;
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
       bstree.insert(22);
       bstree.insert(24);
       bstree.insert(-1);
       bstree.insert(-2);
       bstree.insert(-3);
       
       System.out.println();

        List<List<Integer>> levelorder = bstree.levelorder(bstree.root);
         System.out.println(levelorder);

 
    }
}
