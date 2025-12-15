Count Indices to Balance Even and Odd Sums
Difficulty: MediumAccuracy: 74.01%Submissions: 7K+Points: 4
Given an array arr[], count the number of indices such that deleting the element at that index and shifting all elements after it one position left results in an array where the sum of elements at even indices equals the sum at odd indices.

Examples:

Input: arr[] = [2, 1, 6, 4]
Output: 1
Explaination: After removing arr[1], the resulting array will be [2, 6, 4] the sums of elements at odd index is arr[1] = 6 and the sum of elements at even index is arr[0] + arr[2] = 6.
Input: arr[] = [1, 1, 1]
Output: 3
Explaination: Removing any element makes the sum of odd and even indexed elements equal.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104
class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;
        int res = 0;

        int rightOddSum = 0, rightEvenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rightEvenSum += arr[i];
            } else {
                rightOddSum += arr[i];
            }
        }

        int leftOddSum = 0, leftEvenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rightEvenSum -= arr[i];
            } else {
                rightOddSum -= arr[i];
            }
            if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum) {
                res++;
            }
            if (i % 2 == 0) {
                leftEvenSum += arr[i];
            } else {
                leftOddSum += arr[i];
            }
        }

        return res;
    }
}
