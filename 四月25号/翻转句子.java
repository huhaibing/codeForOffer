package CodeForOffer.四月25号;

public class ReverseSentence {
    /*
    题目;
    牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

    思路：反转或者是从最后将字符串进行拼接，频繁的拼接，所以最好使用StringBuffer
     */
    public static void main(String[] args){
        ReverseSentence main = new ReverseSentence();
        main.ReverseSentence("");
    }
    public String ReverseSentence(String str) {
        if(str == null) return null;
        if(str.trim().equals("")){
            return str;
        }
        String[] orignal = str.trim().split(" ");
        int length = orignal.length;
        int i = 0 , j = length - 1;
        while(i < j){
            String temp = orignal[i];
            orignal[i] = orignal[j];
            orignal[j] = temp;
            i++;
            j--;
        }
        String res = orignal[0];
        for(i = 1; i < length; i++){
            res += " " + orignal[i];
        }
        return res;
    }
}
