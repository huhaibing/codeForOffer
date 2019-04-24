package CodeForOffer.四月24号;

public class GetNumberOfK
{
    /*
    题目：统计一个数字在排序数组中出现的次数。

    思路：
    见到排序，那么首先想到的是，二分查找。
    找到该数，向两侧开始遍历。
     */
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0) return 0;
        int start = 0 , end = length -1;
        int num = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            if(array[mid] == k) {
                int left = mid - 1;
                while(left >= 0 && array[left] == k)
                {
                    num++;
                    left--;
                }
                int right = mid + 1;
                while(right <= length - 1 && array[right] == k){
                    num++;
                    right++;
                }
                num++;
                break;
            }
            if(array[mid] < k) start = mid + 1;
            if(array[mid] > k) end = mid - 1;
        }
        return num;
    }
}
