import java.io.*;
import java.util.*;

/**
 * 백준 문제 1003번 '피보나치 함수'
 * https://www.acmicpc.net/problem/1003
 */
public class FibonacciFunction {
  static int fibonacci(int N, int[] zeroOne) {
    if (N == 0) {
      zeroOne[0]++;
      return 0;
    } else if (N == 1) {
      zeroOne[1]++;
      return 1;
    }

    return fibonacci(N - 1, zeroOne) + fibonacci(N - 2, zeroOne);
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine().trim());

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(bf.readLine().trim());
      int[] zeroOne = new int[2];
      int fib = fibonacci(N, zeroOne);

      System.out.print(zeroOne[0] + " ");
      System.out.print(zeroOne[1] + "\n");
    }
  }
}
