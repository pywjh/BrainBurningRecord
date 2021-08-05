"""
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
"""

def dfs(grid, r, c, row, col):
    # 1.终止条件：到达 水的边界
    if r < 0 or c < 0 or r >= row or c >= col or grid[r][c] == 0:
        return

    # 2.对每个遍历到的元素1，都置为0
    grid[r][c] = 0

    # 3.以次坐标为起点，开启四周遍历
    dfs(grid, r, c-1, row, col)
    dfs(grid, r, c+1, row, col)
    dfs(grid, r+1, c, row, col)

    
def count_islands(island):
    if not island or len(island) == 0 or len(island[0]) == 0:
        return

    row = len(island)
    col = len(island[0])
    count = 0

    for r in range(row):
        for c in range(col):
            if island[r][c] == 1:
                # 岛屿+1
                count += 1
                dfs(island, r, c, row, col)
    return count


if __name__ == '__main__':
    island = [
        [1, 1, 0, 1, 1],
        [1, 1, 0, 0, 0],
        [0, 0, 1, 0, 0],
        [1, 0, 0, 1, 1]
    ]
    print(count_islands(island))