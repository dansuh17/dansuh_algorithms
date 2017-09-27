import java.io.*;
import java.util.*;

/**
 * 백준 문제 1890번 '점프'
 * https://www.acmicpc.net/problem/1890
 *
 * Dynamic Programming implementation.
 * This scheme is only possible because the move is only to right & down.
 *
 * O(n^2)
 */
public class JumpDp {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine().trim());

    // draw the map
    int[][] map = new int[N][N];
    long[][] dp = new long[N][N];
    for (int i = 0; i < N; i++) {
      String[] rowStr = bf.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(rowStr[j]);
      }
    }

    dp[0][0] = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 2; k++) {
          int x = i;
          int y = j;
          int reach = map[i][j];

          if (reach == 0) continue;

          if (k == 0) {
            x += reach;
          } else {
            y += reach;
          }

          if (x < N && y < N) {
            dp[x][y] += dp[i][j];
          }
        }
      }
    }

    bw.write(dp[N - 1][N - 1] + "\n");

    bw.close();
  }
}