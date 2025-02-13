import javax.swing.tree.TreeNode;

public class CheckSubTree {
    static class TreeNode{
        int data ;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }
    static class BinaryTree{
        static int i=-1;
        public static TreeNode build(int[] arr){
            i++;
            if(arr[i]==-1){
                return null;
            }
            TreeNode newNode = new TreeNode(arr[i]);
            newNode.left=build(arr);
            newNode.right=build(arr);
            return newNode;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true ;
        }
        if(root.data == subRoot.data){
            return match(root, subRoot);
        }
        return isSubtree(root.right, subRoot) && isSubtree(root.left, subRoot);
    }
    public boolean match(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if( p == null && q != null ||  p != null && q == null || p.data != q.data){
            return false;
        }
        return match(p.left,q.left) && match(p.right,q.right);
    }
    public static void main(String[] args) {
        int[] nodes={1,2,-1,-1,-1};
        BinaryTree BT = new BinaryTree();
        TreeNode root = BT.build(nodes);
        
    }    
}
