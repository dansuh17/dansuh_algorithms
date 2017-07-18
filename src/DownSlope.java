import java.io.*;
import java.util.*;

/**
 * 백준 문제 1520번 '내리막길'
 * https://www.acmicpc.net/problem/1520
 */
public class DownSlope {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] dimstrs = bf.readLine().split(" ");
    int M = Integer.parseInt(dimstrs[0]);
    int N = Integer.parseInt(dimstrs[1]);

    // create the map
    List<ArrayList<Integer>> map = new ArrayList<>();
    for (int m = 0; m < M; m++) {
      String[] mapRowStr = bf.readLine().split(" ");
      ArrayList<Integer> mapRow = new ArrayList<>();
      map.add(mapRow);

      for (int n = 0; n < N; n++) {
        mapRow.add(Integer.parseInt(mapRowStr[n]));
      }
    }

    int[][] numPaths = new int[M][N];
    boolean[][] visited = new boolean[M][N];
    int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] numPathRow : numPaths) {
      Arrays.fill(numPathRow, -1);
    }

    // given point - starting point
    numPaths[0][0] = 1;
    visited[0][0] = true;

    // start from 0, 0 for faster memoization - reduces call stacks
    for (int m = 0; m < M; m++) {
      for (int n = 0; n < N; n++) {
        if (!visited[m][n]) {
          findPath(map, m, n, numPaths, adj, M, N, visited);
        }
      }
    }

    System.out.println(numPaths[M - 1][N - 1]);
  }

  /**
   * finds the number of downslope paths
   * @param map the height map
   * @param m coordinate row
   * @param n coordinate column
   * @param numPaths array containing number of downslope paths, -1 if not yet calculated
   * @param adj adjacent offsets
   * @param M maximum row
   * @param N maximum column
   * @param visited visited map
   * @return number of downslope paths to coordinate (m, n)
   */
  public static int findPath(List<ArrayList<Integer>> map, int m, int n, int[][] numPaths,
                             int[][] adj, int M, int N, boolean[][] visited) {
    // if it has been already calculated - return its result
    if (numPaths[m][n] != -1) {
      return numPaths[m][n];
    }

    int height = map.get(m).get(n);
    int result = 0;  // it will remain 0 if there is no adjacent region higher than this coordinate

    for (int[] adjset : adj) {
      int adjM = m + adjset[0];
      int adjN = n + adjset[1];

      // if it lies within the map...
      if (adjM >= 0 && adjM < M && adjN >= 0 && adjN < N) {
        int adjHeight = map.get(adjM).get(adjN);
        if (adjHeight > height) {
          result += findPath(map, adjM, adjN, numPaths, adj, M, N, visited);  // recursive call
        }
      }
    }

    visited[m][n] = true;
    numPaths[m][n] = result;
    return result;
  }
}
