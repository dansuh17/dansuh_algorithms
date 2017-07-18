import java.io.*;
import java.util.*;

/**
 * 백준 문제 4673번 'Self Number'
 * https://www.acmicpc.net/problem/4673
 */
public class SelfNumber {
  public static int selfnum(int n) {
    int target = n;
    while (n > 0) {
      target += (n % 10);
      n /= 10;
    }

    return target;
  }

  public static void main(String[] args) {
    int N = 10000;
    boolean[] sieve = new boolean[N + 1];

    for (int i = 1; i < N + 1; i++) {
      if (!sieve[i]) {
        int test = i;

        while (true) {
          test = selfnum(test);

          if (test > N) {
            break;
          }

          sieve[test] = true;
        }
      }
    }

    for (int i = 1; i < N + 1; i++) {
      if (!sieve[i]) {
        System.out.println(i);
      }
    }


  }
}
