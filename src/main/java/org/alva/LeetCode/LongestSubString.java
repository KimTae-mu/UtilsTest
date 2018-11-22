package org.alva.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class LongestSubString {

/*    private int lengthOfLongestSubstring(String s) {
        String news = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (news.contains(String.valueOf(c))) {
                news += String.valueOf(c);
                i++;
            }
        }
    }*/

    private int lengthOfLongestSubstringWithMap(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


    @Test
    public void testLengthOfString() {
        String s = "abcabcd";
        System.out.println(lengthOfLongestSubstringWithMap(s));
    }
}
