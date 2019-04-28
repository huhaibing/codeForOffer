package CodeForOffer.四月28号;

public class isSymmetrical {

    /*
    题目：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

    思路：
    比较对应点是否符合，如果符合，那么比较左边那个节点的左边和右边那个节点的右边是否符合，以及左边那个节点的右边和右边那个节点的左边是否符合
     */

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isSymmetricalCore(pRoot.left,pRoot.right);
    }
    boolean isSymmetricalCore(TreeNode pLeft , TreeNode pRight){
        if(pLeft == null && pRight == null) return true;
        if(pLeft == null || pRight == null) return false;
        if(pLeft.val != pRight.val){
            return false;
        }
        return isSymmetricalCore(pLeft.left, pRight.right) && isSymmetricalCore(pLeft.right, pRight.left);
    }

}
