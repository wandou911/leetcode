# 283 Move Zeroes

283. 移动零

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



代码

```
public class RemoveDuplicates {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] array = {1,1,1,1,2,2,3};
        int len = solution.removeDuplicates(array);
        for (int i = 0; i < len; i++) {
            System.out.println(array[i]);
        }
        
    }

}
//k 是已整理的数据 
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[k]) {
                d++;
                if (d < 2) {
                    k++;
                    if(i > k) {
                        nums[k] = nums[i];
                    }
                }
            }else {
                k++;
                if(i > k) {
                    nums[k] = nums[i];
                }
                d = 0;
            }
            System.out.printf("k = %d",k);
            System.out.printf(" d = %d",d);
            System.out.printf(" i = %d",i);
            System.out.println();

        }

        return k+1;
    }
}
```

