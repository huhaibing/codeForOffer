package CodeForOffer;

public class NumberOf1Between1AndN_Solution {
    /*
    题目：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

    思路： 计算每一位出现的1的个数。使用递归的思想。
     */
    public static void main(String[] args){
        NumberOf1Between1AndN_Solution main = new NumberOf1Between1AndN_Solution();
        int num = 10000;
        int res = main.NumberOf1Between1AndN_Solution(num);
        System.out.println(res);
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        String num = String.valueOf(n);
        int res = numberOf1(num);
        return res;
    }
    int numberOf1(String num){
        int length = num.length();
        int sum = 0;
        if(length == 1 && Integer.valueOf(num) == 0) return 0;
        if(length == 1 && Integer.valueOf(num) > 0 ) return 1;
        int first = Integer.valueOf(num.substring(0,1));
        if(first > 1){
            sum += Math.pow(10,length - 1);
        }
        else if(first == 1){
            sum += Integer.valueOf(num.substring(1,length)) + 1;
        }
        sum += first * Math.pow(10, length -2) * (length - 1);
        sum += numberOf1(num.substring(1,length));
        return sum;
    }
}
