class Solution {
    private List<Integer>[] adjacencyList;
    private int maxDistance;
    private int farthestNode;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = calculateTreeDiameter(edges1);
        int diameter2 = calculateTreeDiameter(edges2);
        return Math.max(Math.max(diameter1, diameter2), (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1);
    }

    private int calculateTreeDiameter(int[][] edges) {
        int nodes = edges.length + 1; // Number of nodes in the tree
        adjacencyList = new List[nodes];
        Arrays.setAll(adjacencyList, i -> new ArrayList<>());
        maxDistance = 0;
        farthestNode = 0;

        // Build the adjacency list
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }

        // Find the farthest node from any starting point
        depthFirstSearch(0, -1, 0);

        // Find the diameter by starting from the farthest node found
        maxDistance = 0;
        depthFirstSearch(farthestNode, -1, 0);

        return maxDistance;
    }

    private void depthFirstSearch(int currentNode, int parent, int currentDistance) {
        for (int neighbor : adjacencyList[currentNode]) {
            if (neighbor != parent) {
                depthFirstSearch(neighbor, currentNode, currentDistance + 1);
            }
        }
        if (currentDistance > maxDistance) {
            maxDistance = currentDistance;
            farthestNode = currentNode;
        }
    }
}
