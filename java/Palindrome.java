
public class Palindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean isPalindrome = solution.isPalindrome(12221);
        System.out.println(isPalindrome);
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        //边界条件 负数 尾数为0 
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        //数字反转
        //数字反转到一半 判断反转后的值和剩余原值
        int rev = 0;
        while(x > rev) {
            int pop = x % 10;
            x /= 10;
            rev = rev*10 + pop;
        }
        
        return x == rev || x == rev / 10;
    }
}