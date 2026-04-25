/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 

*/

class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, 'T');
            }
            if (board[i][col - 1] == 'O') {
                bfs(board, i, col - 1, 'T');
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j, 'T');
            }
            if (board[row - 1][j] == 'O') {
                bfs(board, row - 1, j, 'T');
            }
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O') {
                    bfs(board, i, j, 'X');
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int rowIndex, int colIndex, char c) {
        Queue<int[]> q = new ArrayDeque<>();
        int row = board.length;
        int col = board[0].length;

        board[rowIndex][colIndex] = c;
        q.add(new int[] {rowIndex, colIndex});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            if (arr[0] - 1 >= 0 && board[arr[0] - 1][arr[1]] == 'O') {
                board[arr[0] - 1][arr[1]] = c;
                q.add(new int[] {arr[0] - 1, arr[1]});
            }
            if (arr[1] - 1 >= 0 && board[arr[0]][arr[1] - 1] == 'O') {
                board[arr[0]][arr[1] - 1] = c;
                q.add(new int[] {arr[0], arr[1] - 1});
            }
            if (arr[0] + 1 < row && board[arr[0] + 1][arr[1]] == 'O') {
                board[arr[0] + 1][arr[1]] = c;
                q.add(new int[] {arr[0] + 1, arr[1]});
            }
            if (arr[1] + 1 < col && board[arr[0]][arr[1] + 1] == 'O') {
                board[arr[0]][arr[1] + 1] = c;
                q.add(new int[] {arr[0], arr[1] + 1});
            }
        }
    }
}