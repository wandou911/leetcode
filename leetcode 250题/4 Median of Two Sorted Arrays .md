## 4. 寻找两个正序数组的中位数

[寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)

给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

```
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        if(total % 2 == 1) {
            int midIndex = total / 2;
            double midian = getKthElement(nums2,nums1,midIndex+1);
            return midian;
        }else {
           int midIndex1 = total / 2 - 1;
           int midIndex2 = total / 2;
           double midian = (getKthElement(nums1,nums2,midIndex1+1) + getKthElement(nums2,nums1,midIndex2+1))/2.0;
           return midian;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while (true) {
            // nums1 里面0个元素 返回nums2第k个元素
            if(index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // nums2 里面0个元素
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            int mid1 = nums1[newIndex1];
            int mid2 = nums2[newIndex2];
            if (mid1 <= mid2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }
    }
}
```
