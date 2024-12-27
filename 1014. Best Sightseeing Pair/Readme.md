# 1014 Best Sightseeing Pair SOlution

## Problem Statement

You are given an integer array `values` where `values[i]` represents the value of the `i-th` sightseeing spot.  

Two sightseeing spots `i` and `j` have a distance `j - i` between them.

The score of a pair `(i < j)` of sightseeing spots is calculated as:  
`values[i] + values[j] + i - j`  
This is the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

---

## Constraints
- `2 <= values.length <= 5 * 10^4`
- `1 <= values[i] <= 1000`

---

## Examples

### Example 1:
**Input:**  
`values = [8,1,5,2,6]`  
**Output:**  
`11`  
**Explanation:**  
The optimal pair is `(i=0, j=2)` where:  
`values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11`.  

### Example 2:
**Input:**  
`values = [1,2]`  
**Output:**  
`2`  
**Explanation:**  
The optimal pair is `(i=0, j=1)` where:  
`values[i] + values[j] + i - j = 1 + 2 + 0 - 1 = 2`.

---

## Intuition

The problem involves finding a pair `(i, j)` where `i < j` such that the value of the sightseeing score is maximized.  
The challenge lies in balancing the sightseeing values and the distance penalty.

---

## Approach

1. **Rewriting the Expression:**  
   - Rewrite the score as:  
     `values[i] + i + values[j] - j`  
     - Here, `values[i] + i` contributes a maximum value for the left sightseeing spot.  
     - `values[j] - j` is the value for the right sightseeing spot adjusted by the distance.

2. **Iterative Calculation:**  
   - Traverse the array while maintaining:  
     - `maxPrev` to track the maximum value of `values[i] + i` for the left side.
     - Calculate the score for each `j` using the formula:  
       `maxPrev + values[j] - j`.  
     - Update the maximum score.
   - Update `maxPrev` for each iteration.

---

## Complexity

- **Time Complexity:**  
  $$O(n)$$  
  - We traverse the array once, updating values at each step.

- **Space Complexity:**  
  $$O(1)$$  
  - Only constant space is used for variables.

---

## Code

```java
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxPrev = values[0]; // Track the max value of values[i] + i

        for (int j = 1; j < values.length; j++) {
            // Calculate the maximum score for the current pair
            maxScore = Math.max(maxScore, maxPrev + values[j] - j);
            // Update maxPrev for the next iteration
            maxPrev = Math.max(maxPrev, values[j] + j);
        }

        return maxScore;
    }
}
```

---

## How to Use

1. Copy the provided Java code into your development environment.
2. Create an instance of the `Solution` class.
3. Call the `maxScoreSightseeingPair(int[] values)` method with the input array.
4. The function will return the maximum sightseeing score.

---

## License

This solution is provided under the MIT License. Use, modify, and distribute it freely for educational or personal purposes.