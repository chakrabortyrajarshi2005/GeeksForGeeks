Number of distinct subsequences
Difficulty: HardAccuracy: 30.43%Submissions: 75K+Points: 8
Given a string str consisting of lowercase english alphabets, the task is to find the number of distinct subsequences of the string
Note: Answer can be very large, so, ouput will be answer modulo 109+7.

Examples:

Input: str = "gfg"
Output: 7
Explanation: 
The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .
Input: str = "ggg"
Output: 4
Explanation: 
The four distinct subsequences are "", "g", "gg", "ggg".
Constraints:
1 ≤ |str| ≤ 105
str contains lower case English alphabets

class Solution {
    int distinctSubseq(String str) {
        int n = str.length();
        int mod = 1000000007;
        int[] last = new int[26];
        int res = 1;

        for (int i = 1; i <= n; i++) {
            int cur = (int)(((2L * res) % mod - last[str.charAt(i - 1) - 'a'] + mod) % mod);
            last[str.charAt(i - 1) - 'a'] = res;
            res = cur;
        }
        return res;
    }
}
