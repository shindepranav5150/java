import java.util.ArrayList;

public class MergeBST {
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
            return ;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public static Node buildBST(ArrayList<Integer> list,int start,int end){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(list.get(mid));
        root.left = buildBST(list, start, mid-1);
        root.right = buildBST(list, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2){

        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root1,list);
        getInorder(root2,list);
        list.sort(null);
        
        return buildBST(list,0,list.size()-1);
    }
    public static void main(String[] args) {
        /*
             BST 1      BST2 
              2          9
             /  \       /  \
            1    4     3   12

                 Merged BST
                      3
                    /  \ 
                   1    9
                   \   / \
                    2  4  12
         */

         Node root1 =new Node(2);
         root1.left = new Node(1);
         root1.right = new Node(4);

         Node root2 = new Node(9);
         root2.left = new Node(3);
         root2.right = new Node(12);

         Node root = mergeBST(root1,root2);
         preorder(root);

    }
}
