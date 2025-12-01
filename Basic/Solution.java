
public class Solution {
    // Public API: returns true if word exists in board
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        char[] w = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == w[0]) {
                    if (dfs(board, i, j, w, 0)) return true;
                }
            }
        }
        return false;
    }

    // DFS from cell (r,c) trying to match w[idx..]
    private boolean dfs(char[][] board, int r, int c, char[] w, int idx) {
        if (idx == w.length) return true; // matched all characters
        // bounds + character check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (board[r][c] != w[idx]) return false;

        // mark visited by temporarily changing the cell
        char saved = board[r][c];
        board[r][c] = '#';

        // explore 4 directions
        boolean found = dfs(board, r - 1, c, w, idx + 1)
                     || dfs(board, r + 1, c, w, idx + 1)
                     || dfs(board, r, c - 1, w, idx + 1)
                     || dfs(board, r, c + 1, w, idx + 1);

        // restore
        board[r][c] = saved;
        return found;
    }

    // Helper to create board from String[][] literal (for easy tests)
    private static char[][] toCharGrid(String[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = arr[i][j].charAt(0);
            }
        }
        return grid;
    }

    // Main with the three examples
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] b1 = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        char[][] board1 = toCharGrid(b1);
        System.out.println(sol.exist(board1, "ABCCED")); // true

        String[][] b2 = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        char[][] board2 = toCharGrid(b2);
        System.out.println(sol.exist(board2, "SEE")); // true

        String[][] b3 = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        char[][] board3 = toCharGrid(b3);
        System.out.println(sol.exist(board3, "ABCB")); // false
    }
}
