Max min Height
Difficulty: HardAccuracy: 62.86%Submissions: 33K+Points: 8
Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.

Examples:

Input: arr[] = [2, 3, 4, 5, 1], k = 2, w = 2
Output: 2
Explanation: The minimum height after watering is 2.
Day 1: Water the last two flowers -> arr becomes [2, 3, 4, 6, 2]
Day 2: Water the last two flowers -> arr becomes [2, 3, 4, 7, 3]
Input: arr[] = [5, 8], k = 5, w = 1
Output: 9
Explanation: The minimum height after watering is 9.
Day 1 - Day 4: Water the first flower -> arr becomes [9, 8]
Day 5: Water the second flower -> arr becomes [9, 9]
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ w ≤ arr.size()
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 109

Expected Complexities
Topic Tags
.class Solution {
    public boolean isPossible(int[] arr, int k, int w, int maxHeight) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long currentWater = 0;
        long remainingK = k;

        for (int i = 0; i < n; i++) {
            currentWater += diff[i];
            long currentHeight = arr[i] + currentWater;

            if (currentHeight < maxHeight) {
                long needed = maxHeight - currentHeight;
                if (needed > remainingK) return false;
                
                remainingK -= needed;
                currentWater += needed;
                
                if (i + w < n) {
                    diff[i + w] -= needed;
                }
            }
        }
        return true;
    }

    public int maxMinHeight(int[] arr, int k, int w) {
        int low = Integer.MAX_VALUE;
        for (int x : arr) low = Math.min(low, x);

        int high = low + k;
        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
