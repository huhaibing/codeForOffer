package CodeForOffer.五月十八号;

import java.util.HashMap;
import java.util.Map;

class LRUCache {


    /*
    题目：运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache( 2  缓存容量  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4

思路：因为最好是O(1)的时间复杂度，所有首先查看一定是想到的是使用MAP，但是怎么维护这个缓存呢，缓存需要一定大小的。
开始的时候最先想到的是队列，但是队列可以符合先进先出的原则，但是当命中的时候或者再次插入同样的数据的时候，需要把数据
从队列的某个位置放到队列的头部。所以这里使用双向链表，如果配合上map，双向链表可以快速的插入和删除节点。所以可以实现o（1）
复杂度

注意：put和get都算是命中，都会更新，然后针对双向链表的操作，删除节点的时候，要注意是不是节点头部和尾部。
     */
    static class Node{
        int val;
        int key;
        Node next;
        Node pre;
        public Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    int count = 0;
    Node head = null;
    Node tail = null;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node tmp = map.get(key);
        if(tmp == null) return -1;
        else {
            put(key,tmp.val);
            return tmp.val;
        }
    }

    public void put(int key, int value) {
        Node tmp = new Node(key,value);
        //添加一个节点
        if(head == null){
            tmp.next = tmp;
            tmp.pre = tmp;
            head = tmp;
            tail = tmp;
        }
        else
        {
            tail.next = tmp;
            tmp.pre = tail;
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
        }

        //命中和不命中
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(node == tail) tail = node.pre;
            if(head == node) head = node.next;
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }
        else{
            if(count == capacity){
                int k = tail.key;
                map.remove(k);
                Node pre = tail.pre;
                pre.next = head;
                head.pre = pre;
                tail = pre;
            }
            else{
                count++;
            }
        }
        map.put(key,tmp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
