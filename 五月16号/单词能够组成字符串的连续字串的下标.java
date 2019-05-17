package CodeForOffer.五月十六号;

import java.util.ArrayList;
import java.util.List;

public class FindSubstring {
    public static void main(String[] args) {
        FindSubstring main = new FindSubstring();
//        String[] words = {"foo","bar"};
//        String s = "barfoothefoobarman";
        String[] words = {"word","good","best","word"};
        String s = "wordgoodgoodgoodbestword";
        List<Integer> lists = main.findSubstring(s,words);
        for (Integer tmp : lists)
            System.out.println(tmp);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int length = s.length();
        List<Integer> list = new ArrayList<>();
        List<String> strs = new ArrayList<>();
        int size = words.length;
        for(int i = 0; i < size; i++){
            strs.add(words[i]);
        }
        for(int i = 0 ;i < length; i++){
            if(isRight(s.substring(i),strs)){
                list.add(i);
            }
        }
        return list;
    }
    Boolean isRight(String s, List<String> words){
        int size = words.size();
        if(size == 0){
            return true;
        }
        boolean flag = false ;
        for(int i = 0 ; i < size; i++){
            String word = words.get(i);
            if(s.length() < word.length()) continue;
            if(s.substring(0,word.length()).equals(word)){
                words.remove(word);
                flag = isRight(s.substring(word.length()),words);
                words.add(word);
                if(flag == true) return true;
            }
        }
        return false;
    }
}
