package CodeForOffer.五月十六号;

public class ReverseKGroup {

    /*
    题目：
    给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

    示例 :

    给定这个链表：1->2->3->4->5

    当 k = 2 时，应当返回: 2->1->4->3->5

    当 k = 3 时，应当返回: 3->2->1->4->5

    说明 :

    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


    思路：

    判断是否满足K个，如果满足K个，那么进行反转，不满足直接返回。反转的过程，可以使用两种方法：
    一种双指针移动的方式，一种取出一个节点，然后当做头，然后再取出一个，在当做头，然后连接上原来那个头

    后面两个函数是今天字节面试的题目，题目稍微有点变化，每隔K个进行反转。
    递归实现
     */
    public static void main(String[] args) {
        ReverseKGroup main = new ReverseKGroup();
        ListNode head = main.buildList();
//        ListNode result = main.reverseKGroup(head,2);
//        ListNode result = main.reverseAll(head,2);
        ListNode result = main.reverseAll2(head,2);
        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    ListNode buildList(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || k == 1 || head == null) return head;
        ListNode cur = head;
        EnougthResult nextResult = null;
        ListNode shead = null;
        ListNode stail = null;
        while(true){
            //判断是否可以翻转
            nextResult = isEnough(cur,k);
            if(nextResult.code == 0) {
                if(stail == null){
                    shead = cur;
                }
                else{
                    stail.next = cur;
                }
                break;
            }
            else{
                Result result = reverse(cur,k);
                if(shead == null){
                    shead = result.head;
                }
                if(stail != null){
                    stail.next = result.head;
                    stail = result.tail;
                }
                else{
                    stail = result.tail;
                }
            }
            cur = nextResult.node;
        }
        return shead;
    }
    static class EnougthResult{
        int code;
        ListNode node;
        public EnougthResult(int code, ListNode node){
            this.code = code;
            this.node = node;
        }
    }
    EnougthResult isEnough(ListNode cur, int k){
        while(k != 0 && cur != null){
            cur = cur.next;
            k--;
        }
        if(k == 0) return new EnougthResult(1,cur);
        else return new EnougthResult(0,cur);
    }
    static class Result{
        ListNode head;
        ListNode tail;
        public Result(ListNode head, ListNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    Result reverse(ListNode cur, int k){
        ListNode tail = cur;
        ListNode head = null;
        ListNode next = cur.next;
        while(k != 0 ){
            cur.next = head;
            head = cur;
            cur = next;
            if(next != null) next = next.next;
            k--;
        }
        return new Result(head,tail);
    }
    /*
    反转的思想是滑动窗口
     */
    ListNode reverseAll(ListNode head,int k){
        if(head == null || k <= 1 ) return head;
        int num = k;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        num--;
        while(num != 0 && next != null){
           pre = cur;
           cur = next;
           next = next.next;
           cur.next = pre;
           num--;
        }
        if (num != 0) {
            head.next = null;
            return cur;
        }
        head.next = reverseAll(next,k);
        return cur;
    }

    /*
        反转使用的思想是取一个做一个头，取一个做一个头。
     */
    ListNode reverseAll2(ListNode head,int k){
        if(head == null || k <= 1 || head.next == null) return head;
        ListNode newHead = null;
        ListNode cur = head;
        ListNode next = cur.next;
        int num = k;
        while (num != 0 && cur != null){
            cur.next = newHead;
            newHead = cur;
            cur = next;
            if(next != null) next = next.next;
            num--;
        }
        head.next = reverseAll2(cur,k);
        return newHead;
    }

}
