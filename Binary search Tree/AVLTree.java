public class AVLTree {
    static class Node{
        int data,height;
        Node left, right;

        Node(int data){
            this.data = data;
            height = 1;
            left = right = null;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }

        return root.height;
    }

    public static int balanceFactor(Node root){
        if(root == null){
            return 0;
        }

        return getHeight(root.left) - getHeight(root.right);
    }

    public static Node leftRotation(Node x){
        Node y = x.right;
        Node t2 = y.left;

        //perform rotation
        y.left = x;
        x.right = t2;

        // update height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
        
        //return new root
        return y;
    }

    public static Node rightRotation(Node x){
        Node y = x.left;
        Node t2 = y.right;

        //perform rotation
        y.right = x;
        x.left = t2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;

        //return new root
        return y;
    }

    public static Node insert(Node root, int data){
        // insert the node in BST

        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        }
        else{       // if data is alredy present
            return root;
        }

        // calculate the height of current node
        root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;

        // calculate the balance factor
        int bf = balanceFactor(root);


        //LL case
        if(bf > 1 && data < root.left.data){
            return rightRotation(root);
        }

        //RR case
        if(bf < -1 && data > root.right.data){
            return leftRotation(root);
        }

        // LR case
        if(bf > 1 && data > root.left.data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // RL case
        if(bf < -1 && data < root.right.data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;

    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,25};
        Node root = null;

        for(int i=0;i<arr.length;i++){
            root = insert(root, arr[i]);
        }
        preorder(root);
    }
}
