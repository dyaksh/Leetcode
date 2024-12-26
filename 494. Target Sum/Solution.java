import java.util.HashMap;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum) {
            return 0;
        }

        int offset = sum; // Shift index to handle negative sums
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][offset] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + offset] > 0) {
                    dp[i][j + offset + nums[i - 1]] += dp[i - 1][j + offset];
                    dp[i][j + offset - nums[i - 1]] += dp[i - 1][j + offset];
                }
            }
        }

        return dp[nums.length][target + offset];
    }
}
