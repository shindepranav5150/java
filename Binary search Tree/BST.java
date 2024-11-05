import java.util.ArrayList;

class BST{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(root.data > data){
            root.left = insert(root.left, data);
        }
        else{
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data  + " ");
        inorder(root.right);
    }

    public static boolean search(Node root,int key){    //O(H)   H --> height of tree
        if(root==null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    //delete Node
    public static Node delete(Node root, int val){
        //search Node
        if(val < root.data){
            root.left = delete(root.left, val);
        } 
        else if(val > root.data){
            root.right = delete(root.right, val);
        }

        else{ // node found which want to delete
            //case 1 - leaf Node
            if(root.left == null && root.right == null){
                return null;
            }
            // case2 - single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case3 - both children
            //find inorder successor of node which is leftmost node in right subtree
            Node IS = findInorderSuccessor(root.right);

            root.data= IS.data;
            root.right = delete(root.right, IS.data);
          }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //Print in range 
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data>= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }

    // root to leaf path
    public static void pathRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        pathRootToLeaf(root.left, path);
        pathRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        // inorder(root);
        // System.out.println();
        // delete(root, 1);
        // inorder(root);

        // printInRange(root, 5, 12);

        pathRootToLeaf(root, new ArrayList<>());

    }
}