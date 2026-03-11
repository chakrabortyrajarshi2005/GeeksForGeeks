Sum of subarray minimums
Difficulty: MediumAccuracy: 46.92%Submissions: 38K+Points: 4Average Time: 30m
Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.

Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.

Examples:

Input: arr[] = [10, 20]
Output: 40
Explanation: Subarrays are [10], [20], [10, 20]. Minimums are 10, 20, 10.
Sum of all these is 40.
Input: arr[] = [1, 2, 3, 4]
Output: 20
Explanation: Subarrays are [1], [2], [3], [4], [1, 2], [1, 2, 3], [1, 2, 3, 4], [2, 3], [2, 3, 4], [3, 4]. Minimums are 1, 2, 3, 4, 1, 1, 1, 2, 2, 3.
Sum of all these is 20.
Constraints:
1 ≤ arr.size() ≤ 3*104
1 ≤ arr[i] ≤ 103

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) right[i] = i;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        dp[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int r = right[i];
            if (r == i) {
                dp[i] = (n - i) * arr[i];
            } else {
                dp[i] = (r - i) * arr[i] + dp[r];
            }
        }

        int sum = 0;
        for (int val : dp) sum += val;
        return sum;
    }
}
class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) right[i] = i;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        dp[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int r = right[i];
            if (r == i) {
                dp[i] = (n - i) * arr[i];
            } else {
                dp[i] = (r - i) * arr[i] + dp[r];
            }
        }

        int sum = 0;
        for (int val : dp) sum += val;
        return sum;
    }
}
