package CodeForOffer.四月24号;

public class FindNumsAppearOnce {
    /*
   题目：
   一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

   思路：
可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或
 的结果，所以根据异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据
 这样继续对每一半相异或则可以分别求出两个只出现一次的数字

     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if(length  < 2) return;
        int tmp = 0;
        for(int i = 0 ; i < length ; i++)
            tmp ^= array[i];
        if(tmp == 0) return ;
        int index = 0;
        while((tmp & 1) != 1){
            tmp = tmp >> 1;
            index++;
        }
        int a = 0 , b = 0;
        int pos = 1;
        pos = pos << index;
        for(int i = 0; i < length; i++){
            if((pos & array[i]) == 0){
                a ^= array[i];
            }
            else{
                b ^= array[i];
            }
        }
        num1[0] = a;
        num2[0] = b;
        return;
    }
}
