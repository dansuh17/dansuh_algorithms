import javafx.scene.layout.Priority;

import java.io.*;
import java.util.*;

/**
 * 백준 문제 1766번 '문제집'
 * https://www.acmicpc.net/problem/1766
 *
 * category: topological ordering
 */
public class PracticeBook {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] options = bf.readLine().split(" ");
    int N = Integer.parseInt(options[0]);
    int M = Integer.parseInt(options[1]);

    // N is maximum 32000, and creating a 2d-array (int[][]) will exceed the memory limit
    List<ArrayList<Integer>> dag = new ArrayList<>();
    for (int n = 0; n < N; n++) {
      dag.add(new ArrayList<>());
    }

    // create the graph from the provided information
    int[] indegree = new int[N];
    for (int m = 0; m < M; m++) {
      String[] priorityProbStrs = bf.readLine().split(" ");
      int solveFirst = Integer.parseInt(priorityProbStrs[0]) - 1;
      int solveLater = Integer.parseInt(priorityProbStrs[1]) - 1;

      // draw the dependency
      dag.get(solveFirst).add(solveLater);
      indegree[solveLater]++;
    }

    // use priority queue to order ambiguous topological ordering by problem numbers
    PriorityQueue<Integer> finalOrder = new PriorityQueue<>();
    for (int n = 0; n < N; n++) {
      if (indegree[n] == 0) {
        finalOrder.add(n);
      }
    }

    // topological ordering
    while (!finalOrder.isEmpty()) {
      int solvedProb = finalOrder.poll();
      bw.write(solvedProb + 1 + " ");
      for (int solveLater : dag.get(solvedProb)) {
        if (--indegree[solveLater] == 0) {
          finalOrder.add(solveLater);
        }
      }
    }

    bw.close();
  }
}