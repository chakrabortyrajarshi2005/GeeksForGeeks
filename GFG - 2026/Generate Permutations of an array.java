Generate Permutations of an array
Difficulty: MediumAccuracy: 82.73%Submissions: 7K+Points: 4
Given an array arr[] of unique elements. Generate all possible permutations of the elements in the array.
Note: You can return the permutations in any order, the driver code will print them in sorted order.

Examples:

Input: arr[] = [1, 2, 3]
Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
Explanation: There are 6 possible permutations (3! = 6) of the array.
Input: arr[] = [1, 3]
Output: [[1, 3], [3, 1]]
Explanation: There are 2 possible permutations (2! = 2) of the array.
Constraints:
1 ≤ arr.size() ≤ 9

class Solution {
    public static void permutations(ArrayList<ArrayList<Integer>> res, int[] arr,
                                    int idx) {
        if (idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int val : arr) temp.add(val);
            res.add(temp);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
            permutations(res, arr, idx + 1);

            temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permutations(res, arr, 0);
        return res;
    }
};
