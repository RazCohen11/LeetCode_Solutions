/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;
        int mid = (l + r) / 2;

        int row = 0;
        int col = 0;

        while (l < r) {
            row = mid / n;
            col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                l = mid + 1;
                mid = (l + r) / 2;
            }
            else {
                r = mid - 1;
                mid = (l + r) / 2;
            }
        }
        row = mid / n;
        col = mid % n;
        if (row < m && row >= 0 && col < n && col >= 0 && matrix[row][col] == target) {
            return true;
        }
        return false;
    }
}