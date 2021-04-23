## 1. 两数之和

[两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。


```
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        int target = 6;

        Solution solution = new Solution();
        int[] index = solution.twoSumMap(nums, target);
        for (int i=0;i<index.length;i++) {
            System.out.println(index[i]);
        }
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j] == target-nums[i]) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("NO two sum solution");
    }

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("NO two sum solution");
    }
}
```