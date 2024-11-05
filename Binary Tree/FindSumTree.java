/*
    find Sum tree of given tree

    in sum tree 
        node.data = left subtree sum + right subtree sum
 */

public class FindSumTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }

        int sumleft = sumTree(root.left);
        int sumRight = sumTree(root.right);
        
        int data = root.data;
        int newLeft = root.left == null ? 0:root.left.data;
        int newRight = root.right == null ? 0:root.right.data;
        root.data = newLeft+sumleft+newRight+sumRight;
        return data;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        sumTree(root);
        preorder(root);

    }
}
