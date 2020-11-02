import java.util.HashMap;
import java.util.Stack;

import sun.tools.tree.ThisExpression;

public class ValidParenthese {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "(((((())))))";
        String s2 = "()()()()";
        String s3 = "(((((((()";
        System.out.println(solution.isValid(s3));
    }

}

class Solution {

    private HashMap<Character, Character> mappings;
    
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {//如果是右括号 pop并和栈顶元素做比对 如果不匹配，返回false
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}