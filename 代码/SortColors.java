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
    //合并后排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);
    }*/

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