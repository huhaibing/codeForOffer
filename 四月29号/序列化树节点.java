package CodeForOffer.四月29号;

public class SerialTreeNode {

    /*
    题目：
    请实现两个函数，分别用来序列化和反序列化二叉树 ，如果是叶节点那么两个子树为null，使用#表示

    思路：使用深度搜索
     */
    public static void main(String[] args){

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        SerializeCore(root,str);
        return String.valueOf(str);
    }
    StringBuilder SerializeCore(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");
            return str;
        }
        str.append(root.val + ",");
        SerializeCore(root.left, str);
        SerializeCore(root.right, str);
        return str;
    }
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0) return null;
        String[] strNode = str.split(",");
        int[] num = new int[]{0};
        return DeserializeCore(strNode,num);
    }
    TreeNode DeserializeCore(String[] str,int[] num){
        int level = num[0];
        num[0]++;
        if(str[level].equals("#"))
        {
            return null;
        }
        int val = Integer.valueOf(str[level]);
        TreeNode node = new TreeNode(val);
        node.left = DeserializeCore(str,num);
        node.right = DeserializeCore(str,num);
        return node;
    }
}
