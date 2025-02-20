public class Diameter {
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
    static int max = 0;
    public static int height (Node root){
        if(root == null){
            return 0;
        }
        int heightL = height(root.left);
        int heightR = height(root.right);
        if(max < heightL + heightR){
            max = heightL + heightR;
        }
        return 1 + Math.max(heightL,heightR);
    }
    public static void main(String[] args) {
        int[] nodes={1,2,-1,-1,-1};
        BinaryTree BT = new BinaryTree();
        Node root = BT.build(nodes);
        height(root);
        System.out.println("Diameter of the tree: "+max);
    }
}
