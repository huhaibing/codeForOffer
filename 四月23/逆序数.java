package CodeForOffer.四月23;

public class InversePairs {

    /*
    题目：
    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

    思路：
    使用归并的思想，那么归并的两个数组，左边一定比右边的位置靠前，知道比较左边数组比右边数组的大的，所能凑合逆序对的个数。
     */
    public static void main(String[] args){
        InversePairs main = new InversePairs();
        int[] array = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        main.InversePairs(array);
    }
    public int InversePairs(int [] array) {
        int length = array.length;
        if(length == 0) return 0;
        return InversePairsCore(array,0,length - 1);
    }
    public int InversePairsCore(int[] data, int start, int end){
        if(start >= end) return 0;
        int num = 0;
        int mid = (start + end) / 2;
        num += InversePairsCore(data,start,mid);
        num += InversePairsCore(data,mid + 1,end);
        int[] array = new int[end - start + 1];
        int targetPos = end - start;
        int p1 = mid , p2 = end;
        while(p1 >= start && p2 >= mid + 1){
            if(data[p1] > data[p2]){
                num += p2 - mid;
                array[targetPos] = data[p1];
                p1--;
                targetPos--;
            } else {
                array[targetPos] = data[p2];
                p2--;
                targetPos--;
            }
        }
        while(p1 >= start)
        {
            array[targetPos] = data[p1];
            p1--;
            targetPos--;
        }
        while(p2 >= mid + 1){
            array[targetPos] = data[p2];
            p2--;
            targetPos--;
        }
        int index = start;
        for( int i = 0; i < end - start + 1; i++)
        {
            data[index] = array[i];
            index++;
        }
        return num;
    }
}
