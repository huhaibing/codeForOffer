package CodeForOffer;
import java.util.*;

public class GetLeastNumber {
    /*
    题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

    思路：使用优先级队列，来模拟堆排序选出最小的数。


    *基于堆排序算法，构建最大堆。时间复杂度为O(nlogk)
    *如果用快速排序，时间复杂度为O(nlogn)；
    *如果用冒泡排序，时间复杂度为O(n*k)


     */

    public static void main(String[] args){
        GetLeastNumber main = new GetLeastNumber();
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        int k = 4;
        main.GetLeastNumbers_Solution(input,4);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int length = input.length;
        if (length < k) return list;
        for (int i = 0 ; i < length; i++){
            queue.offer(input[i]);
            if(i >= k){
                queue.poll();
            }
        }
        for(Integer tmp : queue)
            list.add(tmp);
        return list;
    }

}
