package CodeForOffer.四月23;

import java.util.*;

public class FindNumbersWithSum {

    /*
    题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

    思路：其实是利用的排序这个特性，从左右两边的指针向中间靠，然后相等对的时候，但是这道题是求积最小的两个数
    那么第一个找到的两个数就是积最小，可以证明的。y = sum - x , mul = x * ( sum - x )

    当然：我写的比较麻烦，可能是开始审题不好，我记录每次找到的结果，把结果进行乘积的比较，选出结果
     */
    public static void main(String[] args){
        FindNumbersWithSum main = new FindNumbersWithSum();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int sum = 21;
        main.FindNumbersWithSum(array,sum);
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int start = 0, length = array.length;
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 0) return list;
        if(length < 2) return null;
        int end = length - 1;
        int min = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;
        int flag = 1;
        while(start < end){
            int add = array[start] + array[end];
            if(add == sum){
                int mul = array[start] * array[end];
                if(mul < min){
                    num1 = array[start];
                    num2 = array[end];
                    min = mul;
                    flag = 0;
                }
                //除去重复。
                while(start < end && array[start] == array[start + 1])
                    start++;
                while(start < end && array[end] == array[end -1])
                    end--;
                start++;
            }
            if(add < sum){
                start = start + 1;
            }
            if(add > sum){
                end = end - 1;
            }
        }
        if(flag == 0){
            list.add(num1);
            list.add(num2);
        }
        return list;
    }

}
