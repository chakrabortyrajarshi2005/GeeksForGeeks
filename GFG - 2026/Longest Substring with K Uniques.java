Longest Substring with K Uniques
Difficulty: MediumAccuracy: 34.65%Submissions: 277K+Points: 4
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        int maxi = -1;
        int[] fre = new int[26];
        while (j < n) {
            fre[s.charAt(j) - 'a']++;
            if (fre[s.charAt(j) - 'a'] == 1) cnt++;
            while (cnt > k) {
                fre[s.charAt(i) - 'a']--;
                if (fre[s.charAt(i) - 'a'] == 0) cnt--;
                i++;
            }
            if (cnt == k) {
                maxi = Math.max(maxi, j - i + 1);
            }

            j++;
        }

        return maxi;
    }
}
