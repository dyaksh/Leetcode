# Intuition
The problem requires determining how many ways we can assign `+` and `-` to the elements of an array to achieve a specific target sum. This can be solved by exploring all possible subsets using a dynamic programming approach to efficiently handle overlapping subproblems.

# Approach
1. **Dynamic Programming Table**:
   - Compute the total sum of the array.
   - Create a DP table `dp[i][j]`, where `i` represents the number of elements considered, and `j` represents the sum that can be formed.

2. **State Transition**:
   - Initialize the base case `dp[0][offset] = 1`, where `offset` shifts the index to handle negative sums.
   - For each element, calculate the number of ways to form a new sum by either adding or subtracting the current number.

3. **Result**:
   - After processing all elements, the result is stored at `dp[n][target + offset]`.

# Complexity
- **Time Complexity**:  
  \(O(n \cdot m)\), where \(n\) is the number of elements in the array and \(m\) is the range of possible sums (\([-sum, sum]\)).
  
- **Space Complexity**:  
  \(O(n \cdot m)\), for storing the DP table.

# Code
```java
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
