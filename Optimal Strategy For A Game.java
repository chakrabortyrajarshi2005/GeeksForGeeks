Optimal Strategy For A Game
Difficulty: MediumAccuracy: 49.03%Submissions: 98K+Points: 4
You are given an integer array arr[] of size n(even). The array elements represent n coins of values v1, v2, ....vn.
You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the coin's value.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Examples:

Input: arr[] = [5, 3, 7, 10]
Output: 15
Explanation: The user collects the maximum value as 15(10 + 5). It is guaranteed that we cannot get more than 15 by any possible moves.
Input: arr[] = [8, 15, 3, 7]
Output: 22
Explanation: The user collects the maximum value as 22(7 + 15). It is guaranteed that we cannot get more than 22 by any possible moves.
Constraints:
2 <= n <= 103
1 <= arr[i] <= 106

class Solution {
    public int maximumAmount(int arr[]) {
        int n = arr.length;
        int sum = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[j] = arr[j];
                } else {
                    dp[j] = Math.max(arr[i] - dp[j], arr[j] - dp[j - 1]);
                }
            }
        }
        return (sum + dp[n - 1]) / 2;
    }
}
