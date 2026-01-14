Police and Thieves
Difficulty: MediumAccuracy: 34.03%Submissions: 54K+Points: 4
Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
Keep in mind the following conditions :

Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than k units away from him.
Examples:

Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
Output: 2
Explanation: Maximum 2 thieves can be caught. First policeman catches first thief and second police man can catch either second or third thief.
Input: arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
Output: 3
Explanation: Maximum 3 thieves can be caught.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ k ≤ 1000
arr[i] = 'P' or 'T'

class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int count = 0;

        while (i < n && j < n) {
            while (i < n && arr[i] != 'P') i++;
            while (j < n && arr[j] != 'T') j++;
            if (i < n && j < n && Math.abs(i - j) <= k) {
                count++;

                i++;
                j++;
            }
            else if (j < n && j < i) {
                j++;
            }
            else if (i < n && i < j) {
                i++;
            }
        }
        return count;
    }
}
