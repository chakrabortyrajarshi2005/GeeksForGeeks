Find H-Index
Difficulty: MediumAccuracy: 53.4%Submissions: 63K+Points: 4
You are given an array citations[], where each element citations[i] represents the number of citations received by the ith paper of a researcher. You have to calculate the researcher’s H-index.
The H-index is defined as the maximum value H, such that the researcher has published at least H papers, and all those papers have citation value greater than or equal to H.

Examples:

Input: citations[] = [3, 0, 5, 3, 0]
Output: 3
Explanation: There are at least 3 papers with citation counts of 3, 5, and 3, all having citations greater than or equal to 3.
Input: citations[] = [5, 1, 2, 4, 1]
Output: 2
Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.
Input: citations[] = [0, 0]
Output: 0
Explanation: The H-index is 0 because there are no papers with at least 1 citation.
Constraints:
1 ≤ citations.size() ≤ 106
0 ≤ citations[i] ≤ 106

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n] += 1;
            else
                freq[citations[i]] += 1;
        }

        int idx = n;
        int s = freq[n];
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        return idx;
    }
}
