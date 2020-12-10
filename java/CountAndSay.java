
public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(4);
        System.out.println(s);
    }

}

class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s= new String("1");

        for (int i = 1; i < n; i++) {
            s = getCNS(s);
        }
        return s.toString();
    }

    public String getCNS(String s) {
        char c = s.charAt(0);
        int count = 1;
        StringBuilder temp = new StringBuilder();
        for (int j = 1; j<s.length(); j++) {
            if (c != s.charAt(j)){
                temp.append(count).append(c);
                c = s.charAt(j);
                count = 1;
            }else{
                count++;
            }
        }
        temp.append(count).append(c);

        return temp.toString();

    }

}