import java.io.*;
import java.util.*;

/**
 * 백준 문제 11066번 '파일 합치기'
 * https://www.acmicpc.net/problem/11066
 */
public class MergingFiles {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(bf.readLine());

    for (int t = 0; t < T; t++) {
      int K = Integer.parseInt(bf.readLine());
      String[] chapterStrs = bf.readLine().trim().split(" ");
      int[] chapterLengths = new int[K];

      for (int k = 0; k < K; k++) {
        chapterLengths[k] = Integer.parseInt(chapterStrs[k]);
      }

      long mergeCost = mergeFiles(chapterLengths, K);
      bw.write(mergeCost + "\n");
    }

    bw.close();
  }

  public static long mergeFiles(int[] chapterLengths, int K) {
    long[][] costs = new long[K][K];

    for (int i = 0; i < K; i++) {
      Arrays.fill(costs[i], -1);
      costs[i][i] = 0;
    }

    return getCost(0, K - 1, costs, chapterLengths);
  }

  public static long getCost(int start, int last, long[][] costs, int[] chapterLengths) {
    if (costs[start][last] != -1) {
      // already recorded
      return costs[start][last];
    }

    long minCost = Long.MAX_VALUE;
    for (int k = start; k < last; k++) {
      long subCostFront = getCost(start, k, costs, chapterLengths);
      long subCostLast = getCost(k + 1, last, costs, chapterLengths);

      long sumCost = subCostFront + subCostLast + sumSubChapters(start, last, chapterLengths);

      if (minCost > sumCost) {
        minCost = sumCost;
      }
    }

    costs[start][last] = minCost;  // record
    return minCost;
  }

  public static long sumSubChapters(int start, int last, int[] chapterLengths) {
    long sum = 0;
    for (int i = start; i <= last; i++) {
      sum += chapterLengths[i];
    }

    return sum;
  }
}