class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1])
            return false;

        return binarySearch(matrix, 0, rows * cols - 1, target);
    }

    private boolean binarySearch(int[][] matrix, int start, int end, int target) {

        if (start > end)
            return false;

        int cols = matrix[0].length;

        int mid = start + (end - start) / 2;

        int row = mid / cols;
        int col = mid % cols;

        if (matrix[row][col] == target)
            return true;

        if (target < matrix[row][col])
            return binarySearch(matrix, start, mid - 1, target);

        return binarySearch(matrix, mid + 1, end, target);
    }
}