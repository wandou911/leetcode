
public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {3,4,4,4,7};
        int val = 4;
        int i = solution.removeElement(a, val);
        System.out.println(i);
    }

}

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}