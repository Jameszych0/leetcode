package hard.backtracking;

import java.util.Arrays;

public class NQueensII52 {
    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        Arrays.fill(board, '.');
        backtracking(0, n, board);
        return count;
    }

    public void backtracking(int row, int n, char[][] board) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, board)) {
                board[row][i] = 'Q';
                backtracking(row + 1, n, board);
                board[row][i] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, int n, char[][] board) {
        // 检查列
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;
        // 检查45
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        // 检查135
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;
        return true;
    }
}
