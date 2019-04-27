package CodeForOffer.四月27号;

public class EntryNodeOfLoop {


    /*
    题目：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

    思路： 找环分为三步：首先使用快慢指针可以得到判断是否存在环，如果是存在环的话，快指针一定能追上慢指针
    第二步，判断环的长度，然后上一步的指针中的一个遍历，再次到达这个点，所经历的长度就是环的长度n
    第三步：使用两个指针，一个指针先走n，然后两个人一起走。相遇的时候就是环的入口。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        return judgeCircle(pHead);
    }
    ListNode judgeCircle(ListNode pHead){
        if(pHead.next == null || pHead.next.next == null) return null;
        ListNode quick = pHead.next.next;
        ListNode slow = pHead.next;
        while(quick != slow){
            if(quick.next == null || quick.next.next == null) return null;
            quick = quick.next.next;
            slow = slow.next;
        }
        int num = 1;
        quick = quick.next;
        while(slow != quick){
            quick = quick.next;
            num++;
        }
        quick = pHead;
        for(int i = 0; i < num; i++)
            quick = quick.next;
        slow = pHead;
        while(slow != quick){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

}
