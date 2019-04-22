package CodeForOffer;

public class FindGreatestSumOfSubArray {
    /*
    题目：
    HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

    思路：
    1、判断之前的和，如果之前的和为负数，那么重新开始计数，如果前面的和为正数，则继承前面数，继续叠加

    2、
该题目思路:
dp[i]表示以元素array[i]结尾的最大连续子数组和.
以[-2,-3,4,-1,-2,1,5,-3]为例
可以发现,
dp[0] = -2
dp[1] = -3
dp[2] = 4
dp[3] = 3
以此类推,会发现
dp[i] = max{dp[i-1]+array[i],array[i]}.
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int length = array.length;
        for(int i = 0; i < length; i++){
            if(sum < 0) sum = array[i];
            else sum += array[i];
            if(sum > max) max = sum;
        }
        return max;
    }
    public static void main(String[] args){
        FindGreatestSumOfSubArray main = new FindGreatestSumOfSubArray();
        int[] input = new int[]{1,-2,3,10,-4,7,2,-5};
        int res = main.FindGreatestSumOfSubArray(input);
        System.out.println(res); int a = args.length;
        System.out.println(Math.pow(3,3));
    }
}
