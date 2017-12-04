/**
 * Longest_Palindromic_Substring_5
 */
public class Longest_Palindromic_Substring_5 {

    //DP
    public String longestPalindrome(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 1,left = 0, right = 0;
        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        for(int i=0;i<s.length()-1;i++)
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                max = 2;
                left = i;
                right = i+1;
            }
        
        for(int i=1;i<s.length();i++) {
            for(int j=0;j<i;j++) {
                if(s.charAt(i) == s.charAt(j) && dp[j+1][i-1]) {
                    dp[j][i] = true;
                    if((i-j+1) > max) {
                        max = i-j+1;
                        left = j;
                        right = i;
                    }
                }
            }
        }
        return s.substring(left, right+1);
    }

    //(Expand Around Center)
    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}