/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'. 
*/

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    islands++;
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        if (arr[0] + 1 < row && grid[arr[0] + 1][arr[1]] == '1') {
                            queue.add(new int[] {arr[0] + 1, arr[1]});
                            grid[arr[0] + 1][arr[1]] = '0';
                        }
                        if (arr[1] + 1 < col && grid[arr[0]][arr[1] + 1] == '1') {
                            queue.add(new int[] {arr[0], arr[1] + 1});
                            grid[arr[0]][arr[1] + 1] = '0';
                        }
                        if (arr[0] - 1 >= 0 && grid[arr[0] - 1][arr[1]] == '1') {
                            queue.add(new int[] {arr[0] - 1, arr[1]});
                            grid[arr[0] - 1][arr[1]] = '0';
                        }
                        if (arr[1] - 1 >= 0 && grid[arr[0]][arr[1] - 1] == '1') {
                            queue.add(new int[] {arr[0], arr[1] - 1});
                            grid[arr[0]][arr[1] - 1] = '0';
                        }
                    }
                }
            }
        }

        return islands;
    }
}