
public class RemoveDuplicates {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] l1 = {1,1,2};
        int len = solution.removeDuplicates(l1);
        System.out.println(len);

        for (int k = 0; k < len; k++) {
            System.out.println(l1[k]);
        }
    }

}

class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
}
 