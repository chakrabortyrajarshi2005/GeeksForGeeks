Sort 0s, 1s and 2s
Difficulty: MediumAccuracy: 50.58%Submissions: 832K+Points: 4Average Time: 10m
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
Note: You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 2class Solution {
    public void sort012(int[] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int mid = 0;

        while (mid <= hi) {
            if (arr[mid] == 0) {
                int temp = arr[lo];
                arr[lo++] = arr[mid];
                arr[mid++] = temp;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi--] = temp;
            }
        }
    }
}
