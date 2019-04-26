package CodeForOffer.四月26号;

public class Duplicate {
    /*
    题目：重复的数值
    思路：遍历数组，将数组上的值放到对应位置上，如果对应位置上已经有这个数了，那么就是重复的
     */
    public static void main(String[] args){
        Duplicate main = new Duplicate();
        int[] numbers = new int[]{2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        main.duplicate(numbers,numbers.length,duplication);
        System.out.println(1);
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0) return false;
        for(int i=0;i<length;++i)
        {
            if(numbers[i]<0||numbers[i]>length-1)
                return false;
        }
        int index = 0;
        while(index < length){
            if(numbers[index] != index){
                if(numbers[numbers[index]] == numbers[index]){
                    duplication[0] = numbers[index];
                    return true;
                }
                else{
                    int temp = numbers[index];
                    numbers[index] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
            else{
                index++;
            }
        }
        return false;
    }
}
