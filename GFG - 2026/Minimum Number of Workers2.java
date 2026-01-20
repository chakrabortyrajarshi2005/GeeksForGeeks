Minimum Number of Workers
Difficulty: MediumAccuracy: 55.15%Submissions: 13K+Points: 4
You are given an array arr[], where arr[i] denotes the range of working hours a person at position i can cover.

If arr[i] ≠ -1, the person at index i can work and cover the time interval [i - arr[i], i + arr[i]].
If arr[i] = -1, the person is unavailable and cannot cover any time.
The task is to find the minimum number of people required to cover the entire working day from 0 to n - 1. If it is not possible to fully cover the day, return -1.

Examples:

Input: arr[] = [1, 2, 1, 0]
Output: 1
Explanation: The person at index 1 can cover the interval [-1, 3]. After adjusting to valid bounds, this becomes [0, 3], which fully covers the entire working day 0 to n -1. Therefore, only 1 person is required to cover the whole day.
Input: arr[] = [2, 3, 4, -1, 2, 0, 0, -1, 0]
Output: -1
Explanation: Persons up to index 2 cover interval [0…6], but working hour 7 cannot be cover as arr[7] = -1, Since the 7th hour cannot be covered by any person, it is impossible to cover the full working day.
Input: arr[] = [0, 1, 0, -1]
Output: -1
Explanation: The last hour cannot be covered by any person, so it is impossible to cover the full working day.
Constraints:
1 ≤ arr.size() ≤105
-1 ≤ arr[i] ≤ arr.size()class Solution {
    public String doc = "";
    Stack<Character> redost = new Stack<>();

    public void append(char X) {
        doc += X;
        while (!redost.isEmpty()) redost.pop();
    }

    public void undo() {
        if (!doc.isEmpty()) {
            char last = doc.charAt(doc.length() - 1);
            doc = doc.substring(0, doc.length() - 1);
            redost.push(last);
        }
    }

    public void redo() {
        if (!redost.isEmpty()) {
            char ch = redost.pop();
            doc += ch;
        }
    }

    public String read() {
        return doc;
    }
}
