Longest subarray with Atmost two distinct integers
Difficulty: MediumAccuracy: 47.98%Submissions: 143K+Points: 4Average Time: 30m
Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

Examples:

Input: arr[] = [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.
Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105class Solution {
    public int totalElements(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = arr.length;
        int size = 0;

        while (j < n) {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);
            while (mp.size() > 2) {
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if (mp.get(arr[i]) == 0) mp.remove(arr[i]);
                i++;
            }

            size = Math.max(size, j - i + 1);
            j++;
        }

        return size;
    }
}
