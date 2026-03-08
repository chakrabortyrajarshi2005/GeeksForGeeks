Pythagorean Triplet
Difficulty: MediumAccuracy: 24.77%Submissions: 269K+Points: 4Average Time: 20m
Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.

Examples:

Input: arr[] = [3, 2, 4, 6, 5]
Output: true
Explanation: a=3, b=4, and c=5 forms a pythagorean triplet.
Input: arr[] = [3, 8, 5]
Output: false
Explanation: No such triplet possible.
Input: arr[] = [1, 1, 1]
Output: false
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 103

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        int maxEle = 0;
        for (int ele : arr) maxEle = Math.max(maxEle, ele);
        boolean[] vis = new boolean[maxEle + 1];
        for (int ele : arr) vis[ele] = true;

        for (int a = 1; a < maxEle + 1; a++) {
            if (!vis[a]) continue;

            for (int b = 1; b < maxEle + 1; b++) {
                if (!vis[b]) continue;
                int c = (int)Math.sqrt(a * a + b * b);
                if ((c * c) != (a * a + b * b) || c > maxEle) continue;
                if (vis[c]) {
                    return true;
                }
            }
        }
        return false;
    }
}
