Missing And Repeating
Difficulty: EasyAccuracy: 24.83%Submissions: 664K+Points: 2Average Time: 30m
Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing, and another number occurs twice in the array, find both the duplicate number and the missing number.

Examples:

Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and the missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and the missing number is 2.
Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.
Constraints:
2 ≤ n ≤ 106
1 ≤ arr[i] ≤ n


class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int repeating = -1;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            } else {
                repeating = val;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
