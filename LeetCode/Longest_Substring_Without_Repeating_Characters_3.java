import java.util.HashMap;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * Longest_Substring_Without_Repeating_Characters_3
 */
public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for(int i=0;i<s.length();i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur))
                left = Math.max(left, map.get(cur)+1);
            map.put(cur, i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

}