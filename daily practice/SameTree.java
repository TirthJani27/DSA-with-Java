
public class SameTree {
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
        
    }
    public boolean isSameTree(DepthOfBTree.Node p, DepthOfBTree.Node q) {
        if(p == null && q == null){
            return true;
        }
        if( p == null && q != null ||  p != null && q == null || p.data != q.data){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
