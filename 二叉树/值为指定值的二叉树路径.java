package CodeForOffer;

import java.util.ArrayList;

public class TreePathForValue {


    /*
    题目：
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

    思路：首先这道题很容易就想到是一个DFS的问题。
    那么如何快速写一个DFS是很关键的
    注意：对象传递的都是地址，里面变化，所有使用指向该对象的所有对象都会变化，还有add集合操作，针对对象
    只是存放了一个指针，当该指针指向的地址对象还有别的指针指向，而且别的指针修改了该对象的时候，集合中的
    该对象也是会变化的。

     */
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    TreeNode buildTree(){
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.right = new TreeNode(12);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(7);
        return head;
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        deepPath(root,pathList,target,0,path);
        return pathList;
    }
    public void deepPath(TreeNode node, ArrayList<ArrayList<Integer>> pathList, int target, int sum,ArrayList<Integer> path){
        if (node == null) return;
        sum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null){
            if (sum == target){
                ArrayList<Integer> goodPath = new ArrayList<>();
                for (Integer tmp : path){
                    goodPath.add(tmp);
                }
                pathList.add(goodPath);
            }
        }
        if (node.left != null) deepPath(node.left,pathList,target,sum,path);
        if (node.right != null) deepPath(node.right,pathList,target,sum,path);
        sum -= node.val;
        path.remove(Integer.valueOf(node.val));
    }


    /*
    不是很好的书写
     */
    /*


    ArrayList<Integer> list = new ArrayList<>();
    int sum = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<>();
        if (root == null) return pathlist;
        sum += root.val;
        list.add(root.val);
        deepSearch(root,target,pathlist);
        return pathlist;
    }
    public void deepSearch(TreeNode node,int target,ArrayList<ArrayList<Integer>> pathlist){
        if(node.left == null && node.right == null){
            if(sum == target) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (Integer tmp: list){
                    arrayList.add(tmp);
                }
                pathlist.add(arrayList);
            }
        }
        if(node.left != null){
            sum += node.left.val;
            list.add(node.left.val);
            deepSearch(node.left,target,pathlist);
            sum -= node.left.val;
            list.remove(Integer.valueOf(node.left.val));
        }
        if(node.right != null){
            sum += node.right.val;
            list.add(node.right.val);
            deepSearch(node.right,target,pathlist);
            sum -= node.right.val;
            list.remove(Integer.valueOf(node.right.val));
        }
    }
    */
}
