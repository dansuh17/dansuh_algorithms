import java.io.*;
import java.util.*;

/**
 * 백준 문제 10844번 '쉬운 계단 수'
 * https://www.acmicpc.net/problem/10844
 */
public class EasyStairNumber {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    long[][] stairTable = new long[N][10];

    for (int n = 0; n < N; n++) {
      for (int i = 0; i < 10; i++) {
        if (n == 0) {
          stairTable[n][i] = 1;
          stairTable[n][0] = 0;
          continue;
        }

        if (i > 0) {
          stairTable[n][i] += stairTable[n - 1][i - 1];
        }

        if (i < 9) {
          stairTable[n][i] += stairTable[n - 1][i + 1];
        }

        stairTable[n][i] %= 1000000000;
      }
    }

    long result = 0;
    for (int i = 0; i < 10; i++) {
      result += stairTable[N - 1][i];
      result %= 1000000000;
    }

    System.out.println(result);
  }
}
