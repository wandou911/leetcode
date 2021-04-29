
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