# 209 Minimum Size Subarray Sum

[209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)

给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

```
class Solution {
    //滑动窗口 [l,r] 左闭右闭
    //
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r+1 < nums.length && sum < target) {
                r++;
                sum += nums[r];
            }else {
                sum -= nums[l];
                l++;
            }

            if (sum >= target) {
                res = Math.min(res,r-l+1);
            }
        }
        //res 未更新过
        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }
}
```
