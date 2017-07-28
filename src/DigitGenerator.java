import java.io.*;
import java.util.*;

/**
 * 백준 문제 2231번 'Digit Generator'
 * https://www.acmicpc.net/problem/2231
 */
public class DigitGenerator {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    long[] constructors = new long[N + 1];
    Arrays.fill(constructors, 0);

    for (int i = 0; i < N + 1; i++) {
      int digitsum = i;
      int tmpidx = i;

      while (tmpidx != 0) {
        digitsum += (tmpidx % 10);
        tmpidx /= 10;
      }

      if (digitsum <= N && constructors[digitsum] == 0) {
        constructors[digitsum] = i;
      }
    }

    System.out.println(constructors[N]);
  }
}
