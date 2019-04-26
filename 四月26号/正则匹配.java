package CodeForOffer.四月26号;

public class Match {
    /*
    题目：正则匹配
    思路：使用状态转移，遍历模式的那个数组，如果第二字符是"*"，如果当前位置的pattern和str的值相等，
    那么有三种情况，第一个就是只是匹配该数字，使用递归吧patter向后推移两位，吧str推移一位，
    一个是一个都不匹配，就是patter向后推移两位，str不动，最后一种是不仅是匹配这一个，所以只是将str向后推移
    如果当前pattern和str不相等，那么就只有将patter向后推移两个位置，这一种方法了

    如果第二个字符不是*,那么就只能是匹配了，不匹配就是错误的
     */
    public static void main(String[] args){
        String str = "a";
        String pattern = ".";
        Match main = new Match();
        boolean flag = main.match(str.toCharArray(),pattern.toCharArray());
        System.out.println(flag);
    }
    public boolean match(char[] str, char[] pattern)
    {
        int strLength = str.length;
        int patLength = pattern.length;
        return matchCore(str,pattern,0,0);
    }
    boolean matchCore(char[] str, char[] pattern, int strS, int patS){
        int strLength = str.length;
        int patLength = pattern.length;
        if(strS == strLength && patS == patLength) return true;
        if(strS != strLength && patS == patLength) return false;
        if(patS < patLength - 1 && pattern[patS + 1] == '*'){
            if(strS < strLength &&(str[strS] == pattern[patS] || pattern[patS] == '.')){
                return matchCore(str,pattern,strS + 1, patS + 2) ||
                        matchCore(str,pattern,strS, patS + 2) ||
                        matchCore(str,pattern,strS + 1, patS );
            }
            else return matchCore(str,pattern,strS , patS + 2);
        }
        else{
            if(strS < strLength  && (str[strS] == pattern[patS] || pattern[patS] == '.')){
                return matchCore(str,pattern,strS + 1, patS + 1);
            }
            else{
                return false;
            }
        }
    }
}
