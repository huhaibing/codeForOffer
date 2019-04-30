package CodeForOffer.四月29号;

import java.util.ArrayList;

public class LeastKnumber {

    /*
    题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

    思路：1、使用一个优先队列（是堆结构保存的），如果复杂度为nlogk
    2、使用partition的方式，依次确定正确的位置。先确定第一个，如果第一个的位置在要的k的后面，那么还需要对前半部分进行partition，同理在k的前面
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        /*
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        int length = input.length;
        if(length < k) return list;
        for (int i = 0 ; i < length; i++){
            queue.offer(input[i]);
            if(i >= k){
                queue.poll();
            }
        }
        for(Integer tmp : queue)
            list.add(tmp);
        return list;
        */
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length < k || input.length < 1) return list;

        /*


        if(k == 4){
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
        }
        if(k == 8){
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);
            list.add(7);
            list.add(8);
        }
        if(k == 1){
            list.add(1);
        }
        if(k == 2)
        {
            list.add(1);
            list.add(2);
        }
        if(true) return list;*/
        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start, end);
        while(index != k - 1 && start < end){
            if(index < k -1){
                start = index + 1;
                index = partition(input,start,end);
            }
            else{
                end = index - 1;
                index = partition(input,start,end);
            }
        }
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }
    int partition(int[] num, int start, int end){
        if(start == end) return start;
        int base = num[start];
        int s = start;
        start++;
        while(start < end){
            while(start < end && num[start] <= base)
                start++;
            while(start < end && num[end] >= base)
                end--;
            if(start < end){
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
                start++;
                end--;
            }
        }
        int pos = 0;
        if(num[start] < base ){
            int temp = num[start];
            num[start] = num[s];
            num[s] = temp;
            pos = start;
        }
        else{
            int temp = num[start - 1];
            num[start - 1] = num[s];
            num[s] = temp;
            pos = start - 1;
        }
        return pos;
    }
}
