class Solution {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    int m;
    int n;

    private void DFS(int[][] grid, int i, int j, boolean[][] visited){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
        return;

        visited[i][j] = true;

        for(int[]dir : direction){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            DFS(grid, new_i, new_j, visited);
        }
    }

    private int numberOfIslandDFS(int[][] grid){
        boolean[][]visited = new boolean[m][n];
        int island = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    DFS(grid, i, j, visited);
                    island++;
                }
            }
        }

        return island;
    }

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int island = numberOfIslandDFS(grid);

        if(island > 1 || island == 0){
            return 0;
        }else{
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(grid[i][j] == 1){
                        grid[i][j] = 0;

                        island = numberOfIslandDFS(grid);

                        grid[i][j] = 1;
                        if(island > 1 || island == 0){
                            return 1;
                        }
                    }
                }
            }
        }
        return 2;
    }
}