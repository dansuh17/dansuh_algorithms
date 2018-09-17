import java.io.*;
import java.util.*;

/**
 * 백준 문제 2839번 '설탕배달'
 * https://www.acmicpc.net/problem/2839
 */
public class SugarDelivery {
  public static void printBag(int[] minBags) {
    for (int i = 0; i < minBags.length; i++) {
      System.out.print(minBags[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] minBags = new int[N + 1];
    Arrays.fill(minBags, -1);

    minBags[0] = 0;
    if (N >= 3) {
      minBags[3] = 1;
    }
    if (N >= 5) {
      minBags[5] = 1;
    }

    for (int n = 6; n < N + 1; n++) {
      if (minBags[n - 3] == -1 && minBags[n - 5] == -1) {
        continue;
      } else if (minBags[n - 3] == -1) {
        minBags[n] = minBags[n - 5] + 1;
      } else if (minBags[n - 5] == -1) {
        minBags[n] = minBags[n - 3] + 1;
      } else {
        minBags[n] = minBags[n - 5] > minBags[n - 3] ? minBags[n - 3] + 1 : minBags[n - 5] + 1;
      }
    }

    System.out.println(minBags[N]);
  }
}
