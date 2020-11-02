
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        int target = 6;

        Solution solution = new Solution();
        int[] index = solution.twoSumMap(nums, target);
        for (int i=0;i<index.length;i++) {
            System.out.println(index[i]);
        }
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j] == target-nums[i]) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("NO two sum solution");
    }

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("NO two sum solution");
    }
}