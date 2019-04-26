package CodeForOffer.四月26号;

public class isNumeric {
    /*
    题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
    思路：
    我的思路是：（小数）[E][正数] 使用状态转移方法
    注意：有的时候如果分支太多，我们可以将对的提出来，不对的直接统一返回错误

    剑指：A[.[B]][e|EC] 或者 .B[e|EC]
     */
    public static void main(String[] args){
        isNumeric main = new isNumeric();
        String temp = "123.45e+6";
        char[] str = temp.toCharArray();
        main.isNumeric(str);
    }
    public boolean isNumeric(char[] str) {
        int length = str.length;
        return isNumericCore(str,0,0);
    }
    boolean isNumericCore(char[] str,int start, int state){
        int length = str.length;
        if(start == length)
        {
            if(state == 3) return true;
            if(state == 1) return true;
            return false;
        }
        if(str[start] == 'E' || str[start] == 'e'){
            if(state == 1) return isNumericCore(str,start + 1, 2);
            else return false;
        }
        if(str[start] == '+' || str[start] == '-') start++;
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        while(start < length && isNumber(str[start])){
            start++;
            flag1 = 1;
        }
        if(start < length && str[start] == '.') {
            flag2 = 1;
            start++;
        }
        while(start < length && isNumber(str[start])){
            start++;
            flag3 = 1;
        }
        if(flag2 == 1 && flag3 == 1){
            if(state == 0){
                return isNumericCore(str,start,1);
            }
            else return false;
        }
        if(flag1 == 1 && flag2 == 0 && flag3 == 0){
            if(state == 0){
                return isNumericCore(str,start,1);
            }
            if(state == 2){
                return isNumericCore(str,start,3);
            }
        }
        return false;
    }
    boolean isNumber(char num){
        boolean flag = false;
        switch(num){
            case '0': flag = true;break;
            case '1': flag = true;break;
            case '2': flag = true;break;
            case '3': flag = true;break;
            case '4': flag = true;break;
            case '5': flag = true;break;
            case '6': flag = true;break;
            case '7': flag = true;break;
            case '8': flag = true;break;
            case '9': flag = true;break;
            default: flag = false;
        }
        return flag;
    }
}
