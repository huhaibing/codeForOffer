package CodeForOffer.五月十八号;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    题目：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

思路：方法一：第一个数遍历n，剩下的两个数的和，可以确定，双指针，n 所以n^2
方法二：确定连个数字和，使用map进行映射，n^2，但是需要n的辅助空间
     */
    public static void main(String[] args) {
        ThreeSum main = new ThreeSum();
        main.threeSum(new int[]{0,0,0,0});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0 ; i < length; i++){
            int target = -nums[i];
            int start = i + 1;
            int end = length - 1;
            if(i - 1 > 0 && nums[i - 1] == nums[i]) continue;//这里很重要，去重是向前进行比较的
            while(start < end){
                int sum = nums[start] + nums[end];
                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                    while(start + 1 <= end && nums[start + 1] == nums[start])//这里当然也需要去重
                        start++;
                    while(start <= end - 1 && nums[end - 1] == nums[end])
                        end--;
                    start++;
                }
                else if(sum > target){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return lists;
    }
}
