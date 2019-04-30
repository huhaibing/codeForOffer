package CodeForOffer.四月30号;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median {
    /*
    题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

    思路：中位数，那么就是左边都是小于的，右边都是大于的，如果能够维护两个堆，一个存放左边的最大值
    一个存放右边的最小值，那么中位数就是这两个最大最小值之间。而且要使得这两边很均衡。
    注意：对于两者堆的数量相等的时候并不是随机的加入到一侧，而是需要判断大小，始终使得左边的最大小于右边的最小。
     */
    public static void main(String[] args){
        Median main = new Median();
        int[] array =new int[]{5,2,3,4,1,6,7,0,8};
        for(int i = 0; i < array.length; i++){
            main.Insert(array[i]);
            System.out.println(main.GetMedian());
        }
    }
    int maxHeap = 0;
    int minHeap = 0;
    Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1 , Integer o2){
            return o2.compareTo(o1);
        }
    });
    Queue<Integer> min = new PriorityQueue<>();

    public void Insert(Integer num) {
        if(maxHeap == minHeap){
            if(maxHeap == 0){
                maxHeap++;
                max.offer(num);
            }
            else{
                if(num > max.peek()){
                    minHeap++;
                    min.offer(num);
                }
                else{
                    maxHeap++;
                    max.offer(num);
                }
            }

        }
        else if(maxHeap > minHeap){
            if(max.peek() < num){
                min.offer(num);
                minHeap++;
            }
            else{
                Integer temp = max.poll();
                max.offer(num);
                min.offer(temp);
                minHeap++;
            }
        }
        else{
            if(min.peek() > num){
                max.offer(num);
            }
            else{
                Integer temp = min.poll();
                min.offer(num);
                max.offer(temp);
            }
            maxHeap++;
        }
    }

    public Double GetMedian() {
        if(maxHeap == minHeap){
            if(maxHeap == 0) return -1.0;
            else return ((double)min.peek() + (double)max.peek()) / 2.0;
        }
        else{
            if(maxHeap > minHeap) return (double)max.peek();
            else return (double)min.peek();
        }
    }


}
