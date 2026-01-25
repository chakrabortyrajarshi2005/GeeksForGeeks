Number of Valid Parentheses
Difficulty: MediumAccuracy: 70.87%Submissions: 6K+Points: 4Average Time: 30m
You are given a number n, your task is to find the number of all the valid parentheses expressions of that length using only "(" and ")" brackets.

An input string of parentheses is valid if :

Open brackets must be closed in correct order.
Every close bracket has a corresponding open bracket.
For example - "()()" or "(())" are valid while ")()(" or "))((" are invalid parentheses expressions.

Examples:

Input: n = 2
Output: 1
Explanation: There is only one possibe valid expressions of length 2 i.e., "()".
Input: n = 4
Output: 2
Explanation: Possibe valid expressions of length 4 are "(())" and "()()".
Input: n = 6
Output: 5
Explanation: Possibe valid expressions of length 6 are "((()))", "(())()", "()(())", "()()()" and "(()())".
Constraints:
1 ≤ n ≤ 20

class Solution {
    int binomialCoeff(int n, int k) {
        int res = 1;

        if (k > n - k) k = n - k;

        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
    int catalan(int n) {
        int c = binomialCoeff(2 * n, n);
        return c / (n + 1);
    }
    int findWays(int n) {
        if ((n & 1) == 1) return 0;
        return catalan(n / 2);
    }
}
