# 26 Remove Duplicates from Sorted Array

26. 删除有序数组中的重复项

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。


```
class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        //第i个元素和num[k] 不相等，k向后移动1位，i个元素移动到k的位置
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[k]) {
                k++;
                if(i>k){
                    nums[k] = nums[i];
                }
                
            }
            
        }

        return k + 1;
    }
}
```
