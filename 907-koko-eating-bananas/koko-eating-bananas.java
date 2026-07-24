class Solution {

    // Check if Koko can finish all bananas with speed = mid
    boolean isPossible(int[] piles, int h, int mid) {

        long totalHours = 0;

        for (int pile : piles) {

            // Ceiling division
            totalHours += (pile + mid - 1) / mid;

        }

        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;

        // Maximum possible speed = largest pile
        int end = 0;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int ans = end;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (isPossible(piles, h, mid)) {

                ans = mid;        // Store current possible answer
                end = mid - 1;    // Try smaller speed

            } else {

                start = mid + 1;  // Increase speed
            }
        }

        return ans;
    }
}