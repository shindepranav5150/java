public class SortedArrayToBalancedBST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(int arr[],int start,int end){
        int mid = start + (end-start)/2;
        
        if(start>end){
            return null;
        }
        Node root = new Node(arr[mid]);
        root.left = insert(arr, start, mid-1);
        root.right = insert(arr, mid+1, end);

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

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = null;
        root = insert( arr, 0, arr.length-1);

        preorder(root);
    }
}
