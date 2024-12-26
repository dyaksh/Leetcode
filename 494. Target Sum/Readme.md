# 494. Target Sum

## Problem Statement

You are given an integer array `nums` and an integer `target`.  
You want to build an expression out of `nums` by adding one of the symbols `'+'` or `'-'` before each integer in `nums` and then concatenate all the integers.

Return the number of different expressions that you can build, which evaluates to `target`.

---

### Constraints:
- `1 <= nums.length <= 20`
- `0 <= nums[i] <= 1000`
- `0 <= sum(nums[i]) <= 1000`
- `-1000 <= target <= 1000`

---

## Example

### Example 1:
Input:
nums = [1,1,1,1,1], target = 3

Output:5
Explanation:  
There are 5 ways to assign symbols to make the sum of `nums` equal to `target` 3:
- `-1 + 1 + 1 + 1 + 1 = 3`
- `+1 - 1 + 1 + 1 + 1 = 3`
- `+1 + 1 - 1 + 1 + 1 = 3`
- `+1 + 1 + 1 - 1 + 1 = 3`
- `+1 + 1 + 1 + 1 - 1 = 3`

### Example 2:
Input:
nums = [1], target = 1
Output:1

---

## Approach

The problem can be solved using **Dynamic Programming (DP)**.  
We use a 2D DP table `dp[i][j]` to represent the number of ways to achieve sum `j` using the first `i` elements of `nums`.

### Steps:

1. **Calculate total sum of `nums`:**  
   Compute the sum of all numbers in `nums`. If `target` is greater than this sum or less than the negative of this sum, return `0` because no solution exists.

2. **Offset for handling negative sums:**  
   Use an offset equal to the total sum to handle indices in the DP table that correspond to negative sums.

3. **Base Case:**  
   Initialize `dp[0][offset] = 1` because there's only one way to achieve sum `0` using no elements.

4. **Transition:**  
   For each element in `nums`, update the DP table by adding and subtracting the element from all possible sums achieved so far.

5. **Result:**  
   The result is stored in `dp[n][target + offset]`, where `n` is the length of `nums`.

---

## Complexity Analysis

- **Time Complexity:** `O(n * s)`  
  `n` is the size of `nums`, and `s` is the total sum of elements in `nums`. Each element is processed for every possible sum.

- **Space Complexity:** `O(n * s)`  
  The DP table requires space proportional to the size of `nums` and the sum of elements.

---

## Solution Code (Java)

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // If target is out of bounds, no solution exists
        if (target > sum || target < -sum) {
            return 0;
        }

        int offset = sum; // Offset to shift the index for negative sums
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        
        // Base case: 0 sum can be achieved with no elements
        dp[0][offset] = 1;

        // Fill the DP table
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
---


## How to Run the Code
1. Define an array of integers nums and a target value target.
2. Instantiate the Solution class.
3. Call the findTargetSumWays(nums, target) method with the array and target as inputs.
4. The method will return the number of ways to assign symbols to achieve the target sum.

---



## License

This solution is provided under the MIT License. Feel free to use, modify, and distribute it for personal or educational purposes.