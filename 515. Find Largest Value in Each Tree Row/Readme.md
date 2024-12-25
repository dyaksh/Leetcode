# 515. Find Largest Value in Each Tree Row

# Largest Values in Each Tree Row

## Problem Statement

Given the `root` of a binary tree, return a list of the largest values in each row of the tree (0-indexed).

### Constraints:
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`.

---

## Example

### Example 1:
Input:
```
root = [1,3,2,5,3,null,9]
```
Output:
```
[1,3,9]
```

### Example 2:
Input:
```
root = [1,2,3]
```
Output:
```
[1,3]
```

### Example 3:
Input:
```
root = []
```
Output:
```
[]
```

---

## Approach

The solution uses a **Breadth-First Search (BFS)** traversal to find the largest value at each level of the binary tree.

### Steps:
1. Use a queue to perform level-order traversal of the tree.
2. At each level:
   - Track the maximum value of the nodes.
   - Add the child nodes of the current level to the queue for the next iteration.
3. Append the maximum value of each level to the result list.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - Every node in the tree is visited exactly once.
- **Space Complexity:** `O(w)`
  - The maximum size of the queue is determined by the width `w` of the tree (i.e., the maximum number of nodes at any level).

---

## Solution Code (Java)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                maxVal = Math.max(maxVal, current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(maxVal);
        }
        
        return result;
    }
}
```

---

## How to Run the Code

1. Define a binary tree using the `TreeNode` class.
2. Instantiate the `Solution` class.
3. Call the `largestValues(TreeNode root)` method with the root of the binary tree as input.
4. The method will return a list of integers, where each integer is the largest value in the corresponding row of the tree.

---

## License

This solution is provided under the MIT License. Feel free to use, modify, and distribute it for personal or educational purposes.
