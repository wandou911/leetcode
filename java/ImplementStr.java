
public class ImplementStr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "hello";
        String s2 = "ll";
        int i = solution.strStr(s1, s2);
        System.out.println(i);
    }

}

class Solution {
    public int strStr(String haystack, String needle) {
        
        int index = 0;
        if (null == needle || needle.isEmpty()) {
            return 0;
        }

        if (null == haystack || haystack.isEmpty()) {
            return -1;
        } 


        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String matched = haystack.substring(i, i+needle.length());
            if (matched.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
    
}