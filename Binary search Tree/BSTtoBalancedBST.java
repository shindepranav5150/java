import java.util.ArrayList;

public class BSTtoBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data  + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left,list);
        list.add(root.data);
        getInorder(root.right,list);
    }

    public static Node convertBSTtoBalancedBST(ArrayList<Integer> list,int start,int end){
        
        if(start>end){
            return null;
        }

        int mid = start + (end-start)/2;
        Node root = new Node(list.get(mid));
        root.left = convertBSTtoBalancedBST(list, start, mid-1);
        root.right = convertBSTtoBalancedBST(list, mid+1, end);

        return root;
    }

    public static Node balacedBST(Node root){    // O(n)
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);

        return convertBSTtoBalancedBST(list, 0, list.size()-1);
    }


    public static void main(String[] args) {

        /*
                Given BST
                    8
                   /  \
                  6    10
                 /      \
                5        11
               /          \
              3            12
        */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);



        /*
                Balance BST
                    8
                   /  \
                  5     11
                 / \    / \
                3   6  10 12
        */

        root = balacedBST(root);
        preorder(root);
    }
}
