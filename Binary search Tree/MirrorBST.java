/*
    Given BST      |    Mirror BST
        8          |        8
       / \         |       /  \
      5   10       |     10    5
     / \   \       |    /     / \
    3   6   11     |   11    6   3
*/

public class MirrorBST {

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

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data  + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }

        Node leftSubtreeMirror = mirrorBST(root.left);
        Node rightSubtreeMirror = mirrorBST(root.right);

        root.left = rightSubtreeMirror;
        root.right = leftSubtreeMirror;
        return root;
    }
    

     public static void main(String args[]){
        int values[] = {8,5,3,6,10,11};
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        preorder(root);
        System.out.println();
        mirrorBST(root);
        preorder(root);
    }
}
