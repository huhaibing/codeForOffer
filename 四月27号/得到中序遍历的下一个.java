package CodeForOffer.四月27号;

public class GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    /*
    题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
    思路：分类讨论，最好在写之前将这些情况都写出来。
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        else{
            if(pNode.next == null){
                return null;
            }
            else{
                TreeLinkNode dad = pNode.next;
                if(dad.right == pNode){
                    while(dad.next != null && dad.next.right == dad)
                        dad = dad.next;
                    return dad.next;
                }
                else{
                    return dad;
                }
            }
        }
    }
}
