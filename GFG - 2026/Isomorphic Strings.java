Isomorphic Strings
Difficulty: EasyAccuracy: 34.21%Submissions: 228K+Points: 2Average Time: 30m
Given two strings s1 and s2 consisting of only lowercase English letters and of equal length, check if these two strings are isomorphic to each other.
If the characters in s1 can be changed to get s2, then two strings, s1 and s2 are isomorphic. A character must be completely swapped out for another character while maintaining the order of the characters. A character may map to itself, but no two characters may map to the same character.

Examples:

Input: s1 = "aab", s2 = "xxy"
Output: true
Explanation: Each character in s1 can be consistently mapped to a unique character in s2 (a → x, b → y).
Input: s1 = "aab", s2 = "xyz"
Output: false
Explanation: Same character 'a' in s1 maps to two different characters 'x' and 'y' in s2.
Input: s1 = "abc", s2 = "xxz"
Output: false
Explanation: Two different characters 'a' and 'b' in s1 maps with same character 'x' in s2. 
Constraints:
1 ≤ s1.size() = s2.size() ≤ 105

class Solution {

    public boolean areIsomorphic(String s1, String s2) {
        int n = s1.length();

        boolean[] marked = new boolean[26];
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) map[i] = -1;

        for (int i = 0; i < n; i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            if (map[u] == -1) {``
                if (marked[v]) return false;
                map[u] = v;
                marked[v] = true;
            }
            else if (map[u] != v) {
                return false;
            }
        }

        return true;
    }
}
