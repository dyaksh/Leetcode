# Minimum Diameter After Merge

This Java program calculates the minimum possible diameter of a resulting tree after merging two undirected trees by connecting a node from one tree to a node in the other.

## Problem Description

You are given two undirected trees:
1. Tree 1 with `n` nodes and `edges1` representing its edges.
2. Tree 2 with `m` nodes and `edges2` representing its edges.

You can connect one node from Tree 1 to any node in Tree 2. The goal is to determine the minimum diameter of the resulting merged tree. The diameter of a tree is defined as the length of the longest path between any two nodes.

## Solution Approach

The program solves the problem by:
1. **Calculating the diameter of both trees** independently using the "farthest node twice DFS" technique.
2. Using the formula to compute the minimum diameter of the merged tree:
   \[
   \text{minDiameter} = \max\left(\text{diameter1}, \text{diameter2}, \frac{\text{diameter1} + 1}{2} + \frac{\text{diameter2} + 1}{2} + 1\right)
   \]

## Implementation Details

- The program uses adjacency lists to represent trees for efficient traversal.
- Two DFS calls are used to compute the diameter of each tree:
  1. Find the farthest node from an arbitrary node.
  2. Use that farthest node as the starting point to find the actual diameter.
- The result is computed by combining the diameters of both trees.

## Code Structure

### Class: `Solution`

- **Method**: `minimumDiameterAfterMerge(int[][] edges1, int[][] edges2)`
  - Calculates the minimum diameter after merging the two trees.

- **Method**: `calculateTreeDiameter(int[][] edges)`
  - Computes the diameter of a tree represented by `edges`.

- **Method**: `depthFirstSearch(int currentNode, int parent, int currentDistance)`
  - Traverses the tree and updates the maximum distance and farthest node.

## Input Format

1. `edges1`: A 2D array representing the edges of Tree 1.
2. `edges2`: A 2D array representing the edges of Tree 2.

### Example Input

```java
edges1 = [[0,1],[0,2],[0,3]];
edges2 = [[0,1]];
