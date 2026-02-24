Longest Span in two Binary Arrays
Difficulty: MediumAccuracy: 48.22%Submissions: 36K+Points: 4
Given two binary arrays, a1[] and a2[] of equal length. Find the length of longest common span (i, j), where i<= j such that a1[i] + a1[i+1] + .... + a1[j] =  a2[i] + a2[i+1] + ... + a2[j].

Examples:

Input: a1[] = [0, 1, 0, 0, 0, 0], a2[] = [1, 0, 1, 0, 0, 1]
Output: 4
Explanation: The longest span with same sum is from index 1 to 4 (0-based indexing).
Input: a1[] = [0, 1, 0, 1, 1, 1, 1], a2[] = [1, 1, 1, 1, 1, 0, 1]
Output: 6
Explanation: The longest span with same sum is from index 1 to 6 (0-based indexing).
Input: a1[] = [0, 0, 0], a2[] = [1, 1, 1]
Output: 0
Explanation: There is no span where the sum of the elements in a1[] and a2[] is equal.
Constraints:
1 ≤ a1.size() = a2.size() ≤ 106
0 ≤ a1[i], a2[i] ≤ 1class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        int maxLen = 0;

        HashMap<Integer, Integer> diffMap = new HashMap<>();

        int prefixSum1 = 0, prefixSum2 = 0;

        for (int i = 0; i < n; i++) {
            prefixSum1 += a1[i];
            prefixSum2 += a2[i];

            int currentDiff = prefixSum1 - prefixSum2;

            if (currentDiff == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }

            else if (diffMap.containsKey(currentDiff)) {
                maxLen = Math.max(maxLen, i - diffMap.get(currentDiff));
            } else {

                diffMap.put(currentDiff, i);
            }
        }

        return maxLen;
    }
}
