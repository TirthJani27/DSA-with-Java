package Binary_trees;
public class Making_A_Binary_Trees {
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

    public static void main(String[] args) {
        int[] nodes={15,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        Node root =BT.build(nodes);
        System.out.println(root.data);


    }
}
