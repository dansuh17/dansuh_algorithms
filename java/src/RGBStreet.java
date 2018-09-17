import java.io.*;
import java.util.*;

/**
 * 백준 문제 1149번 'RGB거리'
 * https://www.acmicpc.net/problem/1149
 */
public class RGBStreet {
  // printing for debugging
  public static void printMinCosts(int[][] minCosts) {
    for (int i = 0; i < minCosts.length; i++) {
      int[] thisRow = minCosts[i];
      for (int j =0; j < thisRow.length; j++) {
        System.out.print(minCosts[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int minCost(List<ArrayList<Integer>> costs, int numHouse) {
    int[][] minCosts = new int[3][numHouse];

    for (int n = 0; n < numHouse; n++) {
      // first row
      if (n == 0) {
        minCosts[0][0] = costs.get(0).get(0);
        minCosts[1][0] = costs.get(0).get(1);
        minCosts[2][0] = costs.get(0).get(2);
        continue;
      }

      for (int c = 0; c < 3; c++) {
        int thisCost = costs.get(n).get(c);
        int minCost = -1;

        for (int k = 0; k < 3; k++) {
          if (k == c) continue;  // exclude the one with same color
          int prevCost = minCosts[k][n - 1];

          // DP
          if (minCost > prevCost + thisCost || minCost == -1) {
            minCost = prevCost + thisCost;
          }
        }

        minCosts[c][n] = minCost;
      }
    }

    int totalMinCost = -1;
    for (int c = 0; c < 3; c++) {
      if (totalMinCost == -1 || totalMinCost > minCosts[c][numHouse - 1]) {
        totalMinCost = minCosts[c][numHouse - 1];
      }
    }

    // printMinCosts(minCosts);
    return totalMinCost;
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    // number of houses
    int N = Integer.parseInt(bf.readLine());
    List<ArrayList<Integer>> costs = new ArrayList<>();

    // for each color RGB ...
    for (int n = 0; n < N; n++) {
      ArrayList<Integer> costRow = new ArrayList<>();
      costs.add(costRow);
      String[] costStrs = bf.readLine().split(" ");

      // for each house...
      for (int c = 0; c < 3; c++) {
        costRow.add(Integer.parseInt(costStrs[c]));
      }
    }

    // print the minimum cost for painting all houses
    System.out.println(minCost(costs, N));
  }
}
