// import java.util.ArrayList;

// import javax.swing.tree.TreeNode;

// public class KthSmallestElement {
//     ArrayList<Integer> arr = new ArrayList<>();
//     public int kthSmallest(TreeNode root, int k) {
//         dfs(root);
//         return arr.get(k-1);
//     }
//     private void dfs(TreeNode root){
//         if(root == null)
//         return;
//         dfs(root.left);
//         arr.add(root.val);
//         dfs(root.right);
//         return;
//     }
// }
