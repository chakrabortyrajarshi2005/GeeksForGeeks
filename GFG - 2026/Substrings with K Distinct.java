Substrings with K Distinct
Difficulty: MediumAccuracy: 20.46%Submissions: 188K+Points: 4Average Time: 20m
You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]
Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]
Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]
Constraints:
1 ≤ s.size() ≤ 106
1 ≤ k ≤ 26class Solution {
    public int count(String s, int k) {
        int n = s.length();
        int ans = 0;

        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) distinctCnt++;
            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) distinctCnt--;
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }

    public int countSubstr(String s, int k) {
        int n = s.length();
        int ans = 0;
        ans = count(s, k) - count(s, k - 1);

        return ans;
    }
}
