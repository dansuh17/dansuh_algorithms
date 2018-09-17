import java.io.*;
import java.util.*;

/**
 * 백준 문제 1516번 '게임 개발'
 * https://www.acmicpc.net/problem/1516
 *
 * category: Topological Sorting
 * Value updating while topological sorting, with non-deterministic ordering.
 */
public class GameDevelopment {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine());

    int[][] dag = new int[N][N];
    int[] buildTimes = new int[N];
    int[] times = new int[N];
    int[] inDegree = new int[N];

    for (int n = 0; n < N; n++) {
      String[] buildContidionsStrs = bf.readLine().trim().split(" ");
      for (int i = 0; i < buildContidionsStrs.length - 1; i++) {
        if (i == 0) {
          buildTimes[n] = Integer.parseInt(buildContidionsStrs[i]);
          continue;
        }

        int dependentBuilding = Integer.parseInt(buildContidionsStrs[i]) - 1;
        dag[dependentBuilding][n] = 1;
        inDegree[n]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int n = 0; n < N; n++) {
      if (inDegree[n] == 0) {
        queue.add(n);
        times[n] = buildTimes[n];
      }
    }

    // update the times while conducting a topological sorting using in-degrees
    while (!queue.isEmpty()) {
      int done = queue.poll();
      int doneTime = times[done];

      for (int m = 0; m < N; m++) {
        if (dag[done][m] == 1) {
          inDegree[m]--;

          // the final build time should be determined as : times[m] = max(time[m], time[prev] + buildTime[m])
          // thanks to the tutorial provided by : https://lyzqm.blogspot.kr/2017/04/1516.html
          int buildTimeFromCurrentDone = doneTime + buildTimes[m];
          times[m] = times[m] > buildTimeFromCurrentDone ? times[m] : buildTimeFromCurrentDone;

          if (inDegree[m] == 0) {
            queue.add(m);
          }
        }
      }
    }

    for (int buildTime : times) {
      bw.write(buildTime + "\n");
    }
    bw.close();
  }
}
