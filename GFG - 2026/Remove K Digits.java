Remove K Digits
Difficulty: MediumAccuracy: 26.8%Submissions: 86K+Points: 4
Given a non-negative integer s represented as a string and an integer k, remove exactly k digits from the string so that the resulting number is the smallest possible, while maintaining the relative order of the remaining digits.

Note : The resulting number must not contain any leading zeros.
If the resulting number is an empty string after the removal, return "0".

Examples:

Input: s = "4325043", k = 3
Output: 2043
Explanation: Remove the three digits 4, 3, and 5 to form the new number "2043" which is smallest among all possible removal.
Input: s = "765028321", k = 5
Output: 221
Explanation: Remove the five digits 7, 6, 5, 8 and 3 to form the new number "0221". Since we are not supposed to keep leading 0s, we get "221".
Constraints:
1 ≤ k ≤ |s| ≤ 106

class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() > c) {
                stk.pop();
                k--;
            }
            if (!stk.isEmpty() || c != '0') stk.push(c);
        }

        while (!stk.isEmpty() && k-- > 0) stk.pop();

        if (stk.isEmpty()) return "0";
        char[] arr = new char[n];
        while (!stk.isEmpty()) {
            arr[n - 1] = stk.pop();
            n--;
        }
        return new String(arr, n, arr.length - n);
    }
}
