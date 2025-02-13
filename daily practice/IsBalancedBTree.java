public class IsBalancedBTree {
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
    public static boolean isBalanced(Node root){
            if(root == null){
                return true;
            }
            boolean[] arr = {true};
            diff(root,arr);
            return arr[0];
        }
        public static int diff(Node root,boolean[] arr){
            if(root == null){
                return 0;
            }
            int leftH = diff(root.left, arr); 
            int rightH = diff(root.right, arr);
            int ans = Math.abs(rightH - leftH);
            if(ans >= 2) arr[0] = false;
            return 1 + Math.max(leftH,rightH);
        }


    public static void main(String[] args) {
        int[] nodes={1,2,-1,-1,-1};
        BinaryTree BT = new BinaryTree();
        Node root = BT.build(nodes);   
        System.out.println(isBalanced(root)); 
    }
}