Count Subset With Target Sum II
Difficulty: MediumAccuracy: 43.16%Submissions: 18K+Points: 4
Given an array arr[] and an integer k, find the count of subsets whose sum is equals to k.

Note: It is guaranteed that the no of valid subsets will fit within a 32-bit integer.

Examples:

Input: arr[] = [1, 3, 2], k = 3
Output: 2
Explanation: The two subsets whose sum is equals to k are [1, 2] and [3].
Input: arr[] = [4, 2, 3, 1, 2], k = 4
Output: 3
Explanation: The three subsets whose sum is equals to k are [4], [2, 2] and [3, 1].
Input: arr[] = [10, 20, 30], k = 25
Output: 0
Explanation: No subsets exits with sum equals to k.
Constraints:
1 ≤ arr.size() ≤ 40
-107 ≤ arr[i], k ≤ 107

class Solution {
    public void genSubset(int[] arr, int index, int currSum,
                          Map<Integer, Integer> freq) {
        if (index == arr.length) {

            freq.put(currSum, freq.getOrDefault(currSum, 0) + 1);
            return;
        }

        genSubset(arr, index + 1, currSum + arr[index], freq);

        genSubset(arr, index + 1, currSum, freq);
    }

    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        Map<Integer, Integer> freqLeft = new HashMap<>();
        Map<Integer, Integer> freqRight = new HashMap<>();
        genSubset(left, 0, 0, freqLeft);
        genSubset(right, 0, 0, freqRight);

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : freqLeft.entrySet()) {
            int sumLeft = entry.getKey();
            int fLeft = entry.getValue();
            int target = k - sumLeft;
            if (freqRight.containsKey(target)) {
                count += fLeft * freqRight.get(target);
            }
        }

        return count;
    }
}
