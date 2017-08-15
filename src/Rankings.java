import java.io.*;
import java.util.*;

/**
 * 백준 문제 3665번 '최종 순위'
 * https://www.acmicpc.net/problem/3665
 *
 * Topological Sorting problem using Queue (detecting ambiguity)
 */
public class Rankings {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(bf.readLine());

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(bf.readLine());
      String[] lastYearStrs = bf.readLine().trim().split(" ");

      int[] lastYearRank = new int[N + 1];
      for (int i = 1; i <= N; i++) {
        lastYearRank[i] = Integer.parseInt(lastYearStrs[i - 1]);
      }

      // create a DAG
      int[][] dag = new int[N + 1][N + 1];
      int[] entranceDegree = new int[N + 1];

      // last year's ranks
      for (int i = 1; i <= N; i++) {
        int ithRank = lastYearRank[i];
        for (int j = i + 1; j <= N; j++) {
          int jthRank = lastYearRank[j];
          dag[ithRank][jthRank] = 1;
          entranceDegree[jthRank]++;
        }
      }

      // get the reversed ranks and create a new DAG
      int M = Integer.parseInt(bf.readLine()); // the number of teams that have their ranks are reversed
      for (int m = 0; m < M; m++) {
        String[] ranksChangedStrs = bf.readLine().trim().split(" ");
        int e1 = Integer.parseInt(ranksChangedStrs[0]);
        int e2 = Integer.parseInt(ranksChangedStrs[1]);

        if (dag[e1][e2] == 1) {
          dag[e1][e2] = 0;
          dag[e2][e1] = 1;

          entranceDegree[e1]++;
          entranceDegree[e2]--;
        } else {
          dag[e2][e1] = 0;
          dag[e1][e2] = 1;

          entranceDegree[e2]++;
          entranceDegree[e1]--;
        }
      }

      Queue<Integer> queue = new LinkedList<>();
      Queue<Integer> rankQueue = new LinkedList<>();
      boolean isAmbiguous = false;
      boolean isImpossible = false;

      // initialize the queue
      for (int i = 1; i <= N; i++) {
        if (entranceDegree[i] == 0) {
          queue.add(i);
        }
      }

      for (int i = 0; i < N; i++) {
        // if the queue is empty, the DAG is incomplete
        if (queue.isEmpty()) {
          // impossible
          isImpossible = true;
          break;
        }

        // if the queue has more than 1 element, there exists multiple ways to determine the ranks
        if (queue.size() > 1) {
          // ambiguous
          isAmbiguous = true;
          break;
        }

        int nextInLine = queue.poll();
        rankQueue.add(nextInLine);  // record the rank

        // iterate through the edges
        for (int j = 1; j <= N; j++) {
          if (dag[nextInLine][j] == 1) {
            entranceDegree[j]--;
            // if next entrance degree is 0, it is definitely next in line
            if (entranceDegree[j] == 0) {
              queue.add(j);
            }
          }
        }
      }

      // test the flags and print the results
      if (isImpossible) {
        bw.write("IMPOSSIBLE\n");
      } else if (isAmbiguous) {
        bw.write("?\n");
      } else {
        for (int rank : rankQueue) {
          bw.write(rank + " ");
        }
        bw.write("\n");
      }
    } // end test cases

    bw.close();
  }
}