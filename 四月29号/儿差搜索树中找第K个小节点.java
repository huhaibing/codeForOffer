package CodeForOffer.四月29号;

public class SearchTreeOfKNode {
    /*
    题目：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     思路：其实就是利用中序遍历的节点排序
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int flag = 0;
    int num = 0;
    int index = 0;
    TreeNode node = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        index = k;
        if(pRoot == null || k < 1) return null;
        DFS(pRoot);
        if(flag == 1) return node;
        return null;
    }
    void DFS(TreeNode root){
        if(flag == 1) return;
        if(root.left != null) DFS(root.left);
        num++;
        if(num == index) {
            flag = 1;
            node = root;
            return;
        }
        if(flag == 1) return;
        if(root.right != null) DFS(root.right);
    }
}
