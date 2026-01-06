Max Xor Subarray of size K
Difficulty: MediumAccuracy: 56.04%Submissions: 11K+Points: 4Average Time: 15m
Given an array of integers arr[]  and a number k. Return the maximum xor of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

Examples:

Input: arr[] = [2, 5, 8, 1, 1, 3], k = 3
Output: 15
Explanation: arr[0] ^ arr[1] ^ arr[2] = 15, which is maximum.
Input: arr[] = [1, 2, 4, 5, 6] , k = 2
Output: 6
Explanation: arr[1] ^ arr[2] = 6, which is maximum.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size()class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        int currXor = 0;

        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        for (int i = k; i < n; i++) {
            currXor ^= arr[i];

            currXor ^= arr[i - k];

            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
