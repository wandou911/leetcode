# 88 Merge Sorted Array

88. 合并两个有序数组

给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。




代码



```
import java.util.*;

public class SortColors {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
        
    }

}

class Solution {
    /*
    //方法1 合并后排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);
    }*/

    //方法2 双指针 
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int cur;
        int[] sortedArray = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2];
                p2++;
            }else if (p2 == n) {
                cur = nums1[p1];
                p1++;
            }else if(nums1[p1] < nums2[p2]) {
                cur = nums1[p1];
                p1++;
            }else {
                cur = nums2[p2];
                p2++;
            }
            sortedArray[p1 + p2 - 1] = cur; 
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sortedArray[i];
        }
    }


}
```