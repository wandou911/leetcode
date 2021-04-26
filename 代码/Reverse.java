
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