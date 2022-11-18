package hard.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(0, n, chessboard);
        return res;
    }

    void backtracking(int row, int n, char[][] chessboard) {
        if (row == n) {
            List<String> path = new ArrayList<>();
            for (char[] c : chessboard) {
                path.add(String.copyValueOf(c));
            }
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtracking(row + 1, n, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < row; i++)
            if (chessboard[i][col] == 'Q')
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j] == 'Q')
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (chessboard[i][j] == 'Q')
                return false;

        return true;
    }
}
