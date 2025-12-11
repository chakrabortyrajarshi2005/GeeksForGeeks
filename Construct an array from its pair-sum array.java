Construct an array from its pair-sum array
Difficulty: EasyAccuracy: 56.62%Submissions: 9K+Points: 2Average Time: 10m
Given a pair-sum array arr[] construct the original array. A pair-sum array for an array is the array that contains sum of all pairs in ordered form, i.e., arr[0] is sum of res[0] and res[1], arr[1] is sum of res[0] and res[2] and so on.

Note: If the size of original array res[] is n, then the size of pair-sum array arr[] would be n * (n -1) /2. We may assume that the pair-sum array arr[] is appropriate in size.
Note that, if the original array is correct then the driver code will print true, else false;

Examples:

Input: arr[] = [4, 5, 3]
Output: true
Explanation: A valid original array is [3, 1, 2], pairwise sums are (3 + 1), (3 + 2) and (1 + 2).
Input: arr[] = [3]
Output: true
Explanation: One of the valid original array is [1, 2].
Constraints: 
1 ≤ n ≤ 103
1 ≤ arr[i] ≤ 109


class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        if (arr.length == 1) {
            return new ArrayList<>(List.of(1, arr[0] - 1));
        }
        int n = (int)((1 + Math.sqrt(1 + 8 * arr.length)) / 2);

        int[] res = new int[n];
        res[0] = (arr[0] + arr[1] - arr[n - 1]) / 2;

        for (int i = 1; i < n; i++) {
            res[i] = arr[i - 1] - res[0];
        }

        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int x : res) ans.add(x);
        return ans;
    }
}
