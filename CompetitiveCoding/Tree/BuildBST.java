
class BST {
    Node root = null;
    static class Node {
        int data;
        Node left,right;
        
        Node(int val) {
            data = val;
            left = null;
            right = null;
            System.out.println(data+" : Constructor ");
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
    
    void print() {
       System.out.print(root.data +" ");
       System.out.print(root.left.data+" ");
       System.out.print(root.right.data+" ");
    }
    
    public static void main(String[] args) {
       BST bstree = new BST();
       bstree.insert(10);
       bstree.insert(5);
       bstree.insert(15);
       bstree.print();
       

       
       
       
    }
}
