    import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeB{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     static class BinaryTree{
        static int idx = -1;

        // create tree by using preorder
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){  // node not present
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // root left right
        public void preorder(Node root){  //O(n)

            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // left root right
        public void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // left right root
        public void  postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // data print levelwise  (BFS)
        // level1 , level2, level3
        public void levelorder(Node root){
            if(root == null){
                return;
            }
            
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data);
                    if(currNode.left != null ){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null ){
                        q.add(currNode.right);
                    }
                }
            }
        }

        // In terms of nodes
        public int heightOfTree(Node root){
            if(root == null){
                return 0;
            }

            return 1+(Math.max(heightOfTree(root.left), heightOfTree(root.right)));
        }

        // Count total no. of nodes
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }

            return 1+countNodes(root.left)+countNodes(root.right);
        }

        // Sum of Nodes
        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            return root.data + sumOfNodes(root.left)+sumOfNodes(root.right);
        }

        //Diameter of tree  --> no. of nodes in the longest path between 2 leaves
        // take the maximum from leftSubTreeDiameter,rightSubTreeDiameter and selfDiameter
        // Approach 1

        public int diameter1(Node root){  // O(n^2)
            if(root == null){
                return 0;
            }
            int leftDiameter = diameter1(root.left);
            int rightDiameter = diameter1(root.right);
            
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            int selfDiameter = leftHeight+rightHeight+1;

            return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));
        }

        // Approach 2

        public static class Info{
            int diameter;
            int height;

            public Info(int diameter, int height){
                this.diameter = diameter;
                this.height = height;
            }
        }
        public Info diameter2(Node root){  // O(n)
            if(root == null){
                return new Info(0,0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diameter = Math.max(leftInfo.height+rightInfo.height+1,Math.max(leftInfo.diameter, rightInfo.diameter));
            int height = Math.max(leftInfo.height,rightInfo.height)+1;

            return new Info(diameter, height);
        }

    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        /*
                 1
                /  \
               2    3
              / \    \
             4  5     6
         */
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelorder(root);
        // System.out.println(tree.heightOfTree(root));

        System.out.println(tree.diameter2(root).diameter);
    }
}