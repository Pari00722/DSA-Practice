public class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;
        if (board[r][c] != word.charAt(idx))
            return false;

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found =
                dfs(board, word, r + 1, c, idx + 1) ||
                dfs(board, word, r - 1, c, idx + 1) ||
                dfs(board, word, r, c + 1, idx + 1) ||
                dfs(board, word, r, c - 1, idx + 1);

        board[r][c] = temp; // restore
        return found;
    }

    // Helper to convert String[][] to char[][]
    private static char[][] toCharGrid(String[][] arr) {
        char[][] grid = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                grid[i][j] = arr[i][j].charAt(0);
            }
        }
        return grid;
    }
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
