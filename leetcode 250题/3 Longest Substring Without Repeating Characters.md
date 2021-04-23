## 3. 无重复字符的最长子串
[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int end = 0; end < s.length(); end++) {
            char a = s.charAt(end);
            if (map.containsKey(a)) {
                start = Math.max(map.get(a)+1,start);
            }
            ans = Math.max(ans,end - start + 1);
            map.put(a,end);
        }

        return ans;
    }
}
```