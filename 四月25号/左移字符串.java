package CodeForOffer.四月25号;

public class LeftRotateString {
    /*
    题目：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

    思路：1、 将前面的字符移动到后面。
    2、原理：YX = (X^T Y^T)^T
     */
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if(length == 0) return "";
        if(n < 0) return null;
        n = n % length;
        char[] front = str.substring(0,n).toCharArray();
        char[] back = str.substring(n,length).toCharArray();
        char[] res = new char[length];
        int index = 0;
        int subLength = back.length;
        for(int i = 0; i < subLength;i++)
        {
            res[index] = back[i];
            index++;
        }
        subLength = front.length;
        for(int i = 0 ; i < subLength; i++){
            res[index] = front[i];
            index++;
        }
        return String.valueOf(res);
    }
}
