import java.io.*;
import java.util.*;

/**
 * 백준 문제 2156번 '포도주 시식'
 * https://www.acmicpc.net/problem/2156
 */
public class WineTasting {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    int[] maxWine = new int[N];
    int[] ml = new int[N];

    for (int n = 0; n < N; n++) {
      // amount of wine
      int w = Integer.parseInt(bf.readLine());
      ml[n] = w;

      if (n == 0) {
        maxWine[n] = w;
        continue;
      }

      if (n == 1) {
        maxWine[n] = w + ml[n - 1];
        continue;
      }

      if (n == 2) {
        maxWine[n] = Math.max(Math.max(maxWine[n - 1], maxWine[n - 2] + w), ml[1] + w);
        continue;
      }

      maxWine[n] = Math.max(Math.max(maxWine[n - 1], maxWine[n - 2] + w), maxWine[n - 3] + ml[n - 1] + w);
    }

    // there are four candidates for the answer : the case of selecting the last wine, or not selecting the last wine
    System.out.println(maxWine[N - 1]);
  }
}
