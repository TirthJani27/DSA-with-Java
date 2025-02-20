class InvertedBTree{
    static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }
    static class BinaryTree{
        static int i=-1;
        public static Node build(int[] arr){
            i++;
            if(arr[i]==-1){
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left=build(arr);
            newNode.right=build(arr);
            return newNode;
        }
        

    }
    public static void printBTree(Node root){
            if(root == null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");
            printBTree(root.left);
            printBTree(root.right);
        }
    public static Node invertBtree(Node root){
        if(root == null){
            return root;
        }
        invertBtree(root.left);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBtree(root.right);
        return root;
    }
    public static void main(String args[]){
        int[] nodes={15,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        Node root =BT.build(nodes);
        printBTree(invertBtree(root));
    }
}