Expression contains redundant bracket or not
Difficulty: MediumAccuracy: 48.71%Submissions: 42K+Points: 4
Given a string of balanced expression s, check if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
Note: Expression may contain + , - , *, and / operators. Given expression is valid and there are no white spaces present.

Examples:

Input: s = "((a+b))"
Output: true 
Explanation: ((a+b)) can reduced to (a+b).
Input: s = "(a+(b)/c)"
Output: true
Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.
Input: s = "(a+b+(c+d))"
Output: false
Explanation:(a+b+(c+d)) doesn't have any redundant or multiple brackets.
Constraints:
1 ≤ |s| ≤105class Solution {
    public boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = str[i];

            if (ch == ')') {
                char top = st.peek();
                st.pop();
                boolean flag = true;

                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        flag = false;
                    }
                    top = st.peek();
                    st.pop();
                }
                if (flag) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
