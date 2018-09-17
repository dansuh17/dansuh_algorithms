import java.io.*;
import java.util.*;

/**
 * 백준 문제 1932번 'The Triangle'
 * https://www.acmicpc.net/problem/1932
 */
public class TheTriangle {
  public static void printTriangle(List<Integer> triangle, int N) {
    int currIdx = 0;
    for (int n = 0; n < N; n++) {
      for (int i = 0; i < n + 1; i++) {
        System.out.print(triangle.get(currIdx) + " ");
        currIdx++;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    List<Integer> triangle = new ArrayList<Integer>();

    // create the triangle
    for (int n = 0; n < N; n++) {
      String[] numbers = bf.readLine().split(" ");
      for (int i = 0; i < n + 1; i++) {
        triangle.add(Integer.parseInt(numbers[i]));
      }
    }

    System.out.println(findMaxPathVal(triangle, N));
  }

  public static int findMaxPathVal(List<Integer> triangle, int N) {
    List<Integer> sums = new ArrayList<Integer>();

    int currIdx = 0;
    // for each level...
    for (int n = 0; n < N; n++) {
      if (n == 0) {
        sums.add(triangle.get(0));
        currIdx++;
        continue;
      }

      int level = n + 1;
      for (int i = 0; i < level; i++) {
        int myVal = triangle.get(currIdx);
        int[] parents = new int[2];

        // get the connections
        // calculate what's connected to current element through index calculation
        if (i == 0) {
          parents[0] = sums.get(currIdx - level + 1);
        } else if (i == level - 1) {
          parents[0] = sums.get(currIdx - level);
        } else {
          parents[0] = sums.get(currIdx - level);
          parents[1] = sums.get(currIdx - level + 1);
        }

        int maxSum = -1;
        for (int j = 0; j < 2; j++) {
          if (maxSum < myVal + parents[j]) {
            maxSum = myVal + parents[j];
          }
        }

        sums.add(maxSum);
        currIdx++;
      }
    }

    // printTriangle(sums, N);
    // find the maximum in last level
    int finalMaxSum = -1;
    int triangleSize = sums.size();
    for (int n = 0; n < N; n++) {
      int finalSum = sums.get(triangleSize - 1 - n);
      if (finalMaxSum < finalSum) {
        finalMaxSum = finalSum;
      }
    }

    return finalMaxSum;
  }
}
