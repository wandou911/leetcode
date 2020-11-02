
public class RomanToInt {
    public static void main(String[] args) {
        
        Solution solution = new Solution();
        String roman = "MMMMMD";
        int romanToInt = solution.romanToInt(roman);
        System.out.println(romanToInt);

    }
}

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char next = (i+1 == s.length()) ?  ' ': s.charAt(i+1);
            switch(s.charAt(i)) {
                case 'I'://1
                    result += (next == 'V' || next == 'X') ? -1 : 1;
                    break;
                case 'V'://5
                    result += 5;
                    break;
                case 'X'://10
                    result += (next == 'L' || next == 'C') ? -10 : 10;
                    break;
                case 'L'://50
                    result += 50;
                    break;
                case 'C'://100
                    result += (next == 'D' || next == 'M') ? -100 : 100;
                    break;
                case 'D'://500
                    result += 500;
                    break;
                case 'M'://1000
                    result += 1000;
                    break;
            }
        }
        

        return result;
    }
}