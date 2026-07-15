public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    sinkIsland(grid, row, col);
                }
            }
        }

        return islands;
    }

    private static void sinkIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';
        sinkIsland(grid, row + 1, col);
        sinkIsland(grid, row - 1, col);
        sinkIsland(grid, row, col + 1);
        sinkIsland(grid, row, col - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}
