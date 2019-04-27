package CodeForOffer.四月27号;

public class DeleteDuplication {
    /*
    题目：
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    思路：
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode cur = pHead;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            while(next != null && next.val == cur.val)
                next = next.next;
            if(next != cur.next){
                if(cur == pHead){
                    pHead = next;
                    cur = next;
                }
                else{
                    pre.next = next;
                    cur = next;
                }
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
}
