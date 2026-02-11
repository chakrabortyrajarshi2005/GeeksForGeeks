Equalize the Towers
Difficulty: MediumAccuracy: 52.18%Submissions: 23K+Points: 4
You are given an array heights[] representing the heights of towers and another array cost[] where each element represents the cost of modifying the height of respective tower.

The goal is to make all towers of same height by either adding or removing blocks from each tower.
Modifying the height of tower 'i' by 1 unit (add or remove) costs cost[i].
Return the minimum cost to equalize the heights of all the towers.

Examples:

Input: heights[] = [1, 2, 3], cost[] = [10, 100, 1000]
OutpuExplanation: The heights can be equalized by either "Removing one block from 3 and adding one in 1" or "Adding two blocks in 1 and adding one in 2". Since the cost of operation in tower 3 is 1000, the first process would yield 1010 while the second one yields 120.
Input: heights[] = [7, 1, 5], cost[] = [1, 1, 1]
Output: 6
Explanation: The minimum cost to equalize the towers is 6, achieved by setting all towers to height 5.
Constraints:
1 ≤ heights.size() = cost.size() ≤ 105
1 ≤ heights[i] ≤ 104
1 ≤ cost[i] ≤ 103

Expected Complexities
Topic Tags
Related Articles
If you are facing any issue on this page. Please let us know.
Java (21)






 

Custom Input
class Solution {
    public int costOfOperation(int[] heights, int[] cost, int target) {
        int totalCost = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            totalCost += Math.abs(heights[i] - target) * cost[i];
        }
        return totalCost;
    }

    public int minCost(int[] heights, int[] cost) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        int minimumCost = Integer.MAX_VALUE;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int cost1 = costOfOperation(heights, cost, mid1);
            int cost2 = costOfOperation(heights, cost, mid2);
            minimumCost = Math.min(minimumCost, Math.min(cost1, cost2));

            if (cost1 == cost2) {
                low = mid1 + 1;
                high = mid2 - 1;
            } else if (cost1 < cost2) {
                high = mid2 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return minimumCost;
    }
}
