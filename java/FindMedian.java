
public class FindMedian {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] {2};
        int[] b = new int[] {};
        double midian = solution.findMedianSortedArrays(a, b);
        System.out.println(midian);
    }

}

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        

        if (total % 2 == 1) {
            int midIndex = total / 2;
            double midian =  getKthElement(nums1, nums2, midIndex+1);
            return midian;
        }else {
            int midIndex1 = total / 2 - 1;
            int midIndex2 = total / 2;
            double midian =  (getKthElement(nums1, nums2, midIndex1+1) + getKthElement(nums1, nums2, midIndex2+1)) / 2.0;
            return midian;
        }

    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        int startIndex1 = 0;
        int startIndex2 = 0;
        
        while (true) {
            if (startIndex1 == length1) {
                return nums2[startIndex2 + k - 1];
            }

            if (startIndex2 == length2) {
                return nums1[startIndex1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[startIndex1], nums2[startIndex2]);
            }

            int half = k / 2;
            int midIndex1 = Math.min(startIndex1 + half, length1) - 1;
            int midIndex2 = Math.min(startIndex2 + half, length2) - 1;
            int mid1 = nums1[midIndex1];
            int mid2 = nums2[midIndex2];
            if (mid1 <= mid2) {
                k -= (midIndex1 - startIndex1 + 1);
                startIndex1 = midIndex1 + 1;
            }else {
                k -= (midIndex2 - startIndex2 + 1);
                startIndex2 = midIndex2 + 1;
            }
        }

    }
    
}