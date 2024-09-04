import java.util.HashSet;
import java.util.Set;

class Solution {
  public int robotSim(int[] commands, int[][] obstacles) {
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ans = 0;
    int d = 0; // 0 := north, 1 := east, 2 := south, 3 := west
    int x = 0; // the start x
    int y = 0; // the start y
    Set<String> obstaclesSet = new HashSet<>();

    // Store obstacles as strings in the format "x,y"
    for (int[] o : obstacles) {
      obstaclesSet.add(o[0] + "," + o[1]);
    }

    for (final int c : commands) {
      if (c == -1) { // Turn right
        d = (d + 1) % 4;
      } else if (c == -2) { // Turn left
        d = (d + 3) % 4;
      } else {
        for (int step = 0; step < c; ++step) {
          int nextX = x + dirs[d][0];
          int nextY = y + dirs[d][1];
          if (obstaclesSet.contains(nextX + "," + nextY)) {
            break; // Stop if the next position is an obstacle
          }
          x = nextX;
          y = nextY;
        }
      }
      ans = Math.max(ans, x * x + y * y); // Update the maximum distance
    }

    return ans;
  }
}
