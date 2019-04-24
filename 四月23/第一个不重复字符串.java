package CodeForOffer.四月23;

public class FirstNotRepeatingChar {

    /*
    题目：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

    思路：因为是出现一次的字母位置，很容易想到使用hash 的方式，而且因为只是字母，最多52个也不多

    注意：首先是大小写的ASCII表位置不是连续的。 A 65 Z 90 a 97 z 122
     */
    public int FirstNotRepeatingChar(String str) {
        int[] zimu = new int[52];
        int[] pos = new int[52];
        char[] chars = str.toCharArray();
        int length = chars.length;
        for(int i = 0; i < length; i++)
        {
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                zimu[chars[i] - 'A']++;
                if(zimu[chars[i] - 'A'] == 1) pos[chars[i] - 'A'] = i;
            }
            if(chars[i] <= 'z' && chars[i] >= 'a'){
                zimu[chars[i] - 'a' + 26]++;
                if(zimu[chars[i] - 'a' + 26] == 1) pos[chars[i] - 'a' + 26] = i;
            }
        }
        int res = 53;
        for(int i = 0; i < 52; i++){
            if(zimu[i] == 1){
                if(pos[i] < res) res = pos[i];
            }
        }
        if(res == 53) res = -1;
        return res;
    }

}
