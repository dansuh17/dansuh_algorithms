import java.io.*;
import java.util.*;

/**
 * 백준 문제 10451번 'Permutation Cycles' (순열사이클)
 * https://www.acmicpc.net/problem/10451
 */
public class PermutationCycles {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine().trim());

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(bf.readLine().trim());
      int[] permutation = new int[N + 1];
      boolean[] visited = new boolean[N + 1];
      String[] strs = bf.readLine().split(" ");

      for (int n = 0; n < N; n++) {
        permutation[n + 1] = Integer.parseInt(strs[n]);
      }

      int cycleCount = 0;
      // should ignore 0! array index starts from 1.
      for (int n = 1; n <= N; n++) {
        // start a DFS unless already visited
        if (!visited[n]) {
          Stack<Integer> stack = new Stack<Integer>();
          stack.push(n);

          // DFS
          while (!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;

            int next = permutation[node];
            if (!visited[next]) {
              stack.push(next);
            }
          }
          cycleCount++;
        }
      }  // n-loop end

      System.out.println(cycleCount);
    }  // t-loop end
  }
}
