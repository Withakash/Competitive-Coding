// LevelOrderTraversal
// Level Order Traversal
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac LevelOrderTraversal.java
// Run:
//   java LevelOrderTraversal
//

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
    
    void inorder(Node root) {
       if(root == null) return;
       
       inorder(root.left);
       System.out.print(root.data + " ");
       inorder(root.right);
    }
    
    
    void levelorder(Node root) {
        if(root == null) return;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            System.out.print(curr.data + " ");
            
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            
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
       bstree.insert(1);
    //   bstree.inorder(bstree.root);
       bstree.levelorder(bstree.root);
 
    }
}
