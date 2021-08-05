package 岛屿数量问题;

public class DaoYu {
    /*
     * 岛屿的个数 给定'1'(陆地) 和'0'(水) 的二维网格图，计算岛屿的数量。
     * 一个岛被水包围，并且通过水平或垂直连接相邻的陆地而形成。你可以假设网格的四个边均被水包围。 
     * 示例1: 
     * 11110 
     * 11010 
     * 11000 
     * 00000
     * 答案: 1 
     * 示例2: 
     * 11000 
     * 11000 
     * 00100 
     * 00011 
     * 答案: 3
     */
    public static int numIslands(int[][] island) {
        if(island == null || island.length == 0) return 0;
        int row = island.length;
        int col = island[0].length;
        int numsIsland = 0;
        // 1.开启循环遍历,
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 2.找到岛屿起点
                if (island[i][j] == 1) {
                    // 3.每进行1次dfs，说明就是找到了一座岛屿
                    ++numsIsland;
                    // 4.每次进行完dfs，就把当前岛屿的元素1，全置换为0
                    dfs(island, i, j, row, col);
                }
            }
        }
        return numsIsland;
    }

    public static void dfs(int[][] grid,int r,int c,int row,int col){

        // 1.终止条件：到达 水的边界
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0)
            return;

        // 2.对每个遍历到的元素1，都置为0
        grid[r][c] = 0;

        // 3.以次坐标为起点，开启四周遍历
        // dfs(grid, r-1, c, row, col);
        dfs(grid, r, c-1, row, col);
        dfs(grid, r, c+1, row, col);
        dfs(grid, r+1, c, row, col);
    }
    
    public static void main(String[] args) {
        // 岛屿的数量
        int[][] island = { 
            { 1, 1, 0, 1, 1 }, 
            { 1, 1, 0, 0, 0 }, 
            { 0, 0, 1, 0, 0 }, 
            { 1, 0, 0, 1, 1 } 
        };
        System.out.println(numIslands(island));
    }
}
