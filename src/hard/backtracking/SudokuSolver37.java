package hard.backtracking;

public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(i, j, val, board)) {
                        board[i][j] = val;
                        if (backtracking(board))
                            return true;
                        board[i][j] = '.';
                    }
                }
                //1~9都遍历完了都没有正确的，就返回false
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, int val, char[][] board) {
        //行
        for (int i = 0; i < 9; i++)
            if (board[row][i] == val)
                return false;
        //列
        for (int i = 0; i < 9; i++)
            if (board[i][col] == val)
                return false;
        //3*3里
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j] == val)
                    return false;
        return true;
    }
}
