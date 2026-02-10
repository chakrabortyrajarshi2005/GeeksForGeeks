Koko Eating Bananas
Difficulty: MediumAccuracy: 50.27%Submissions: 53K+Points: 4Average Time: 20m
Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all the bananas.

Each hour, Koko can choose one pile and eat up to s bananas from it.

If the pile has atleast s bananas, she eats exactly s bananas.
If the pile has fewer than s bananas, she eats the entire pile in that hour.

Koko can only eat from one pile per hour.


Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.

Examples:

Input: arr[] = [5, 10, 3], k = 4
Output: 5
Explanation: If Koko eats at the rate of 5 bananas per hour:
First pile of 5 bananas will be finished in 1 hour.
Second pile of 10 bananas will be finished in 2 hours.
Third pile of 3 bananas will be finished in 1 hours.
Therefore, Koko can finish all piles of bananas in 1 + 2 + 1 = 4 hours.
Input: arr[] = [5, 10, 15, 20], k = 7
Output: 10
Explanation: If Koko eats at the rate of 10 bananas per hour, it will take 6 hours to finish all the piles.
Constraint:
1 ≤ arr.size() ≤ k ≤ 106
1 ≤ arr[i] ≤ 106

Expected Complexities
class Solution {

    boolean check(int[] arr, int mid, int k) {
        int hours = 0;
        for (int i = 0; i < arr.length; i++) {
            hours += arr[i] / mid;

            if (arr[i] % mid != 0) {
                hours++;
            }
        }

        return hours <= k;
    }

    public int kokoEat(int[] arr, int k) {
        int lo = 1;
        int hi = Arrays.stream(arr).max().getAsInt();
        int res = hi;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(arr, mid, k) == true) {
                hi = mid - 1;
                res = mid;
            } else {

                lo = mid + 1;
            }
        }

        return res;
    }
}
