## 7. 整数反转

[7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/)

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。



```
public class Reverse {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int reverse = solution.reverse(12345);
        System.out.println(reverse);
    }

}

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10) && pop < Integer.MIN_VALUE % 10){
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }
}

```