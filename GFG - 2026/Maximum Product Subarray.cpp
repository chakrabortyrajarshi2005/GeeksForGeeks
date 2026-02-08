Maximum Product Subarray
Difficulty: MediumAccuracy: 18.09%Submissions: 497K+Points: 4
Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

Note: It is guaranteed that the answer fits in a 32-bit integer.

Examples

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
Constraints:
1 ≤ arr.size() ≤ 106
-10  ≤  arr[i]  ≤  10class Solution {
    int maxProduct(int[] arr) {

        int n = arr.length;
        int maxProd = Integer.MIN_VALUE;
        int leftToRight = 1;
        int rightToLeft = 1;

        for (int i = 0; i < n; i++) {
            if (leftToRight == 0) leftToRight = 1;
            if (rightToLeft == 0) rightToLeft = 1;
            leftToRight *= arr[i];

            int j = n - i - 1;
            rightToLeft *= arr[j];
            maxProd = Math.max(leftToRight, Math.max(rightToLeft, maxProd));
        }
        return maxProd;
    }
}
