// BoundaryTraversal
// Boundary Traversal of Binary Tree
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac BoundaryTraversal.java
// Run:
//   java BoundaryTraversal
//
// Author: Akash Yadav 


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
    
    List<Integer> res = new ArrayList<Integer>();
    
    List<Integer> boundrytravels(Node root) {
        
        if(root == null) return res;
        
        res.add(root.data);
        
        addleft(root.left);
        addleaf(root);
        addright(root.right);
        
        return res;
    }
    
    void addleft(Node curr) {
        while(curr != null) {
            if(!isLeaf(curr)) res.add(curr.data);
            
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    void addleaf(Node curr) {
        if(curr == null) return;
        
        if(isLeaf(curr)) {
            res.add(curr.data);
            return;
        }
        
        addleaf(curr.left);
        addleaf(curr.right);
    }

  //   #Add leaf using BFS

  //   void addleaf(Node root) {
  //   if (root == null) return;

  //   Queue<Node> q = new LinkedList<>();
  //   q.add(root);

  //   while (!q.isEmpty()) {
  //       Node curr = q.poll();

  //       if (isLeaf(curr)) {
  //           res.add(curr.data);
  //       }

  //       if (curr.left != null) q.add(curr.left);
  //       if (curr.right != null) q.add(curr.right);
  //     }
  // }
    
    void addright(Node curr) {
        Stack<Integer> st = new Stack<>();
        
        while(curr != null) {
            if(!isLeaf(curr)) st.push(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        while(!st.isEmpty()){
            res.add(st.pop());
        }
    }
    
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
       System.out.println();
       System.out.println(bstree.boundrytravels(bstree.root));

    }
}
