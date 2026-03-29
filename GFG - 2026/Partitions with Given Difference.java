Partitions with Given Difference
Difficulty: MediumAccuracy: 36.76%Submissions: 235K+Points: 4Average Time: 20m
Given an array arr[] and an integer diff, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

Note: A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

Examples :

Input: arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
Input: arr[] = [1, 1, 1, 1], diff = 0 
Output: 6 
Explanation: We can choose two 1's from indices [0,1], [0,2], [0,3], [1,2], [1,3], [2,3] and put them in sum1 and remaning two 1's in sum2.
Thus there are total 6 ways for partition the array arr. 
Input: arr[] = [3, 2, 7, 1], diff = 4  
Output: 0
Explanation: There is no possible partition of the array that satisfy the given difference. 
Constraint:
1 ≤ arr.size() ≤ 50
0 ≤ diff ≤ 50
0 ≤ arr[i] ≤ 6class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = Arrays.stream(arr).sum();
        if ((sum + diff) % 2 != 0 || sum < diff) return 0;

        int target = (sum + diff) / 2;
        int n = arr.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= arr[i]; j--) {
                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[target];
    }
}
