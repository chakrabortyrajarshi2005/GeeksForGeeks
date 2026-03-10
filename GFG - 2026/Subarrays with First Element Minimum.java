Subarrays with First Element Minimum
Difficulty: MediumAccuracy: 56.75%Submissions: 15K+Points: 4
You are given an integer array arr[ ]. Your task is to count the number of subarrays where the first element is the minimum element of that subarray.

Note: A subarray is valid if its first element is not greater than any other element in that subarray.

Examples:

Input: arr[] = [1, 2, 1]
Output: 5
Explanation:
All possible subarrays are:
[1], [1, 2], [1, 2, 1], [2], [2, 1], [1]
Valid subarrays are:
[1], [1, 2], [1, 2, 1], [2], [1] -> total 5
Input: arr[] = [1, 3, 5, 2]
Output: 8
Explanation:
Valid subarrays are: [1], [1, 3], [1, 3, 5], [1, 3, 5, 2], [3], [3, 5], [5], [2] -> total 8
Constraints:
1 ≤ arr.size() ≤ 5*104
1 ≤ arr[i] ≤ 105

class Solution {
    public static int countSubarrays(int arr[]) {

        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            while (st.empty() == false && arr[st.peek()] >= arr[i]) st.pop();

            int last = ((st.empty() == true) ? n : st.peek());
            ans += (last - i);
            st.push(i);
        }
        return ans;
    }
}
