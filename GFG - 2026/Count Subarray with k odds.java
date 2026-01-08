Count Subarray with k odds
Difficulty: MediumAccuracy: 51.12%Submissions: 17K+Points: 4Average Time: 20m
You are given an array arr[] of positive integers and an integer k. You have to count the number of subarrays that contain exactly k odd numbers.

Examples:

Input: arr[] = [2, 5, 6, 9], k = 2
Output: 2
Explanation: There are 2 subarrays with 2 odds: [2, 5, 6, 9] and [5, 6, 9].
Input: arr[] = [2, 2, 5, 6, 9, 2, 11], k = 2
Output: 8
Explanation: There are 8 subarrays with 2 odds: [2, 2, 5, 6, 9], [2, 5, 6, 9], [5, 6, 9], [2, 2, 5, 6, 9, 2], [2, 5, 6, 9, 2], [5, 6, 9, 2], [6, 9, 2, 11] and [9, 2, 11].
Constraint:
1 ≤ k ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109

class Solution {

    public int atMostX(int[] arr, int x) {
        int n = arr.length;
        int odd = 0;
        int ans = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) odd++;

            while (odd > x) {
                if (arr[start] % 2 != 0) odd--;
                start++;
            }

            ans += i - start + 1;
        }

        return ans;
    }

    public int countSubarrays(int[] arr, int k) {
        int x = atMostX(arr, k);
        int y = atMostX(arr, k - 1);
        return x - y;
    }
}
