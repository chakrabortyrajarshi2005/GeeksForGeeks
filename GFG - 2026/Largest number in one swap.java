Largest number in one swap
Difficulty: EasyAccuracy: 48.67%Submissions: 36K+Points: 2
Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.

Examples:

Input: s = "768"
Output: "867"
Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically largest string.
Input: s = "333"
Output: "333"
Explanation: Performing any swaps gives the same result i.e "333".
Constraints:
1 ≤ |s| ≤ 105
'0' ≤ s[i] ≤ '9'

class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        char maxDigit = '0';
        int maxIndx = -1, l = -1, r = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxDigit) {
                maxDigit = arr[i];
                maxIndx = i;
            }
            else if (arr[i] < maxDigit) {
                l = i;
                r = maxIndx;
            }
        }

        if (l == -1) return s;

        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        return new String(arr);
    }
}
