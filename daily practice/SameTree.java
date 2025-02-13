import DepthOfBTree.Node;

public class SameTree {
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
