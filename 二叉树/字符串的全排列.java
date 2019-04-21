package CodeForOffer;

import java.util.ArrayList;

public class charPermutation {

    /*
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

    思路：使用交换的方法将每一个位置的字符和后面每一位上的字符进行交换（其实是每一位置上可能存在元素的中类，通过交换来实现每个位置上，元素的种类）

    对于字典序：可以在得到结构以后使用sort方法对结果进行排序，如果原来的字符串是字典序的第一个也可以在交换的时候使用移位。
     */
    public static void main(String[] args){
        String tmp = "abc";
        charPermutation main = new charPermutation();
        main.Permutation(tmp);
    }
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        ArrayList<String> strList = new ArrayList<>();
        if(length == 0 || str == null) return strList;
        swap(chars,0,length,strList);
        for (String tmp : strList)
            System.out.println(tmp);
        return strList;
    }
    void swap(char[] chars,int level,int length,ArrayList<String> strList){
        if(level == length - 1){
            String tmp = String.valueOf(chars);
            strList.add(tmp);
        }
        else{
            for(int i = level; i < length; i++){
                if(i != level && chars[i] == chars[level]) continue;
                swapCharback(chars,level,i);
                swap(chars,level + 1,length,strList);
                swapCharFront(chars,level,i);
            }
        }
    }
    void swapCharback(char[] chars, int a ,int b){
        if (a == b) return;
        char tmp = chars[b];
        for (int i = b; i > a; i--)
            chars[i] = chars[i - 1];
        chars[a] = tmp;
    }
    void swapCharFront(char[] chars, int a , int b){
        if (a == b) return;
        char tmp = chars[a];
        for (int i = a; i < b; i++)
            chars[i] = chars[i + 1];
        chars[b] = tmp;
    }
}
