Happiest Triplet
Difficulty: MediumAccuracy: 53.91%Submissions: 14K+Points: 4Average Time: 35m
You are given three arrays a[], b[], c[] of the same size . Find a triplet such that (maximum-minimum) in that triplet is the minimum of all the triplets. A triplet should be selected so that it should have one number from each of the three given arrays. This triplet is the happiest among all the possible triplets. Print the triplet in decreasing order.

Note: If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.

Examples:

Input: a[] = [5, 2, 8] , b[] = [10, 7, 12] , c[] = [9, 14, 6]
Output: [7, 6, 5]
Explanation: The triplet [5, 7, 6]  has difference (maximum - minimum)= (7 - 5) = 2 which is minimum of all triplets.  
Input: a[] = [15, 12, 18, 9] , b[] = [10, 17, 13, 8] , c[] = [14, 16, 11, 5]
Output: [11, 10, 9]
Explanation: Multiple triplets have the same minimum difference, and among them [11, 10, 9] has the smallest sum, so it is chosen.
Constraints:
1 ≤ a.size(), b.size() ,c.size() ≤ 105
1 ≤ a[i], b[i], c[i] ≤ 105class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0, diff = Integer.MAX_VALUE;

        int x = 0, y = 0, z = 0;
        while (i < a.length && j < b.length && k < c.length) {
            int lo = Math.min(Math.min(a[i], b[j]), c[k]);
            int hi = Math.max(Math.max(a[i], b[j]), c[k]);

            if (diff > hi - lo) {
                diff = hi - lo;
                x = hi;
                y = a[i] + b[j] + c[k] - (hi + lo);
                z = lo;
            }

            if (a[i] == lo)
                i++;
            else if (b[j] == lo)
                j++;
            else
                k++;
        }

        return new int[] {x, y, z};
    }
}
