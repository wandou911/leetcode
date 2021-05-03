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


解法2：滑动窗口

```
class Solution {
    //滑动窗口 [l,r] 左闭右闭
    //
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int res = 0;
        int[] freq = new int[256];
        while (l < s.length()) {
            
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0) {
                char ch = s.charAt(r+1);
                r++;
                freq[ch]++;
            }else {
                char ch = s.charAt(l);
                freq[ch]--;
                l++;
            }

            res = Math.max(res,r-l+1);
        }

        return res;
    }

}
```
