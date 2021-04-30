# 75 Sort Colors   

75. 颜色分类

给定一个包含红色、白色和蓝色，一共 n 
个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。



代码

```

public class SortColors {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] array = {2,0,2,1,1,0};
        solution.sortColors(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        
    }

}

class Solution {

    /*
    //方法2 双指针解法 
    //遍历num[i] 如果 为0，和nums[l]交换 如果 为2，和nums[r]交换
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r; i++) {
            
            //先判断nums[i] == 2; 在判断nums[i] == 0;
            //因为交换之后 nums[i] == 0 不做处理 就会有问题
            while (i < r && nums[i] == 2) {
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
                
            }

            if (nums[i] == 0) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
    }*/

    //单指针 两次遍历 
    //第一次把0放在头部，第二次把1放在0的后面
    public void sortColors(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                int temp = nums[p];
                nums[p] = nums[j];
                nums[j] = temp;
                p++;
            }
        }
    }
}
```