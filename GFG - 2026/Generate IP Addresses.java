Generate IP Addresses
Difficulty: MediumAccuracy: 38.71%Submissions: 51K+Points: 4Average Time: 30m
Given a string s containing only digits, your task is to restore it by returning all possible valid IP address combinations. You can return your answer in any order.

A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255(inclusive).

Note: The numbers cannot be 0 prefixed unless they are 0. For example, 1.1.2.11 and 0.11.21.1 are valid IP addresses while 01.1.2.11 and 00.11.21.1 are not.
If there are no possible valid IP address return an empty list. The driver code will print -1 in this case.

Examples:

Input: s = “255678166”
Output: [“25.56.78.166”, “255.6.78.166”, “255.67.8.166”, “255.67.81.66”]
Explanation: These are the only valid possible IP addresses.
Input: s = “25505011535”
Output: []
Explanation: We cannot generate a valid IP address with this string.
Constraints:
1 ≤ s.size() ≤ 16
s contains only digits(i.e. 0-9)

class Solution {
    static boolean isValid(String s) {
        int n = s.length();
        if (n == 1) return true;
        int val = Integer.parseInt(s);
        if (s.charAt(0) == '0' || val > 255) return false;

        return true;
    }
    static void generateIpRec(String s, int index, String curr, int cnt,
                              ArrayList<String> res) {
        String temp = "";
        if (index >= s.length()) return;

        if (cnt == 3) {
            temp = s.substring(index);
            if (temp.length() <= 3 && isValid(temp)) res.add(curr + temp);

            return;
        }

        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            temp += s.charAt(i);
            if (isValid(temp)) {
                generateIpRec(s, i + 1, curr + temp + ".", cnt + 1, res);
            }
        }
    }

    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        generateIpRec(s, 0, "", 0, res);
        return res;
    }
}
