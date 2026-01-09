Subarrays With At Most K Distinct Integers
Difficulty: MediumAccuracy: 62.09%Submissions: 21K+Points: 4
You are given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the count of distinct integers is at most k.

Note: A subarray is a contiguous part of an array.

Examples:

Input: arr[] = [1, 2, 2, 3], k = 2
Output: 9
Explanation: Subarrays with at most 2 distinct elements are: [1], [2], [2], [3], [1, 2], [2, 2], [2, 3], [1, 2, 2] and [2, 2, 3].
Input: arr[] = [1, 1, 1], k = 1
Output: 6
Explanation: Subarrays with at most 1 distinct element are: [1], [1], [1], [1, 1], [1, 1] and [1, 1, 1].
Input: arr[] = [1, 2, 1, 1, 3, 3, 4, 2, 1], k = 2
Output: 24
Explanation: There are 24 subarrays with at most 2 distinct elements.
Constraints:
1 ≤ arr.size() ≤ 2*104
1 ≤ k ≤ 2*104
1 ≤ arr[i] ≤ 109

class Solution {
    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        int res = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        while (right < n) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            if (freq.get(arr[right]) == 1) k -= 1;

            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) k += 1;
                left += 1;
            }

            res += (right - left + 1);
            right += 1;
        }
        return res;
    }
}
class Solution {
    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        int res = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        while (right < n) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            if (freq.get(arr[right]) == 1) k -= 1;

            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) k += 1;
                left += 1;
            }

            res += (right - left + 1);
            right += 1;
        }
        return res;
    }
}

