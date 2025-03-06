class Solution {
    private int gridSize;
    private int[] parent;
    private int[] clusterSize; 
    private int maxIslandSize = 1;
    private int[] directions = new int[] {-1, 0, 1, 0, -1}; 

    public int largestIsland(int[][] grid) {
        gridSize = grid.length;
        parent = new int[gridSize * gridSize];
        clusterSize = new int[gridSize * gridSize];

        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
            clusterSize[i] = 1;
        }

        for (int i = 0; i < gridSize; ++i) {
            for (int j = 0; j < gridSize; ++j) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; ++k) {
                        int x = i + directions[k];
                        int y = j + directions[k + 1];
                      
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[x][y] == 1) {
                            int rootNeighbor = find(x * gridSize + y);
                            int rootCurrent = find(i * gridSize + j);
                            if (rootNeighbor != rootCurrent) {
                                parent[rootNeighbor] = rootCurrent;
                                clusterSize[rootCurrent] += clusterSize[rootNeighbor];
                                maxIslandSize = Math.max(maxIslandSize, clusterSize[rootCurrent]);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < gridSize; ++i) {
            for (int j = 0; j < gridSize; ++j) {
                if (grid[i][j] == 0) {
                    int potentialSize = 1;
                    Set<Integer> visited = new HashSet<>(); 
                    for (int k = 0; k < 4; ++k) {
                        int x = i + directions[k];
                        int y = j + directions[k + 1];
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[x][y] == 1) {
                            int root = find(x * gridSize + y);
                            if (!visited.contains(root)) {
                                visited.add(root);
                                potentialSize += clusterSize[root];
                            }
                        }
                    }
                    maxIslandSize = Math.max(maxIslandSize, potentialSize);
                }
            }
        }
        return maxIslandSize;
    }

    private int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
