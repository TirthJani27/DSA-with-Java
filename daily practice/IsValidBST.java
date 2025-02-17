import javax.swing.tree.TreeNode;;

public class IsValidBST {
    public static boolean isValidBST(GoodNode.TreeNode root){
            return dfs(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    private static boolean dfs(GoodNode.TreeNode root,int max,int min ){
        if(root == null) return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        return dfs(root.left, root.val, min) && dfs(root.left, min,root.val) ;
    }
    
    public static void main(String[] args) {
        int[] nodes={3,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        GoodNode.BinaryTree BT = new GoodNode.BinaryTree();
        GoodNode.TreeNode root = BT.build(nodes);
        System.out.println(isValidBST(root));
    }
}
