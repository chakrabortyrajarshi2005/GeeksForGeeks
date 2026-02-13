All numbers with specific difference
Difficulty: HardAccuracy: 50.0%Submissions: 13K+Points: 8
Given a positive number n and a number d. Find the count of positive numbers smaller or equal to n such that the difference between the number and sum of its digits is greater than or equal to given specific value d.

Examples:

Input: n = 13, d = 2
Output: 4
Explanation:
There are 4 numbers satisfying the
Conditions. These are 10, 11, 12 and 13.
Input: n = 14, d = 3
Output: 5
Explanation:
There are 5 numbers satisfying the
Conditions. These are 10, 11, 12, 13 and 14.
Constraints:
1 ≤ n ≤ 109
1 ≤ d ≤ 109


class Solution {

    public int sumOfDigit(int K) {
        int sod = 0;
        while (K > 0) {
            sod += K % 10;
            K /= 10;
        }
        return sod;
    }

    public int getCount(int n, int d) {

        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid - sumOfDigit(mid) < d) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return n - high;
    }
}
