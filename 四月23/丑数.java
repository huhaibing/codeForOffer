package CodeForOffer.四月23;

public class GetUglyNumber {

    /*
    题目：
    把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

    思路：
    1、第一个方法肯定是比较直观的，将数从1开始枚举，判断这个数是否符合情况，符合的话，下一个，达到个数跳出。赋上判断函数
    2、第二个思路比较的快，反正后面的丑数一定是前面丑数乘以某个数，那么每次增加一个丑数就是刚刚好超过的那个（针对则三个的最小）。
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int pos2 = 0;
        int pos3 = 0;
        int pos5 = 0;
        int pos = 1;
        while(pos < index){
            int min = getMin(uglyNumbers[pos2] * 2, uglyNumbers[pos3] * 3, uglyNumbers[pos5] * 5);
            uglyNumbers[pos] = min;
            while(uglyNumbers[pos2] * 2 <= min)
                pos2++;
            while(uglyNumbers[pos3] * 3 <= min)
                pos3++;
            while(uglyNumbers[pos5] * 5 <= min)
                pos5++;
            pos++;
        }
        return uglyNumbers[index - 1];
    }
    public int getMin(int a, int b, int c){
        int min = a > b ? b : a;
        min = min > c ? c : min;
        return min;
    }

    boolean isUglyNumber(int number){
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /=5;
        return (number == 1) ? true : false;
    }

}
