import java.io.*;
import java.util.*;

/**
 * 백준 문제 1038번 '감소하는 수'
 * https://www.acmicpc.net/problem/1038
 *
 * *** NOT PASSING -- WHY??? ***
 */
public class ReducingNumbers {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    List<Integer> reducedNums = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    // initial members
    for (int i = 0; i <= 9; i++) {
      reducedNums.add(i);
      queue.add(i);
    }

    int maxIntDigits = calcNumDigits(Integer.MAX_VALUE);

    while (!queue.isEmpty()) {
      int n = queue.poll();

      int numDigits = calcNumDigits(n);
      int lastdigit = n / (int)Math.pow(10, numDigits);  // the digit in largest position

      for (int i = lastdigit + 1; i <= 9; i++) {
        int targetNum = n + i * (int)Math.pow(10, numDigits + 1);
        int targetNumDigits = calcNumDigits(targetNum);
        if (targetNum >= 0 && targetNum < Integer.MAX_VALUE && targetNumDigits != maxIntDigits) {
          reducedNums.add(targetNum);
          queue.add(targetNum);
        }
      }
    }

    if (N >= reducedNums.size()) {
      System.out.println(-1);
    } else {
      Collections.sort(reducedNums);
      System.out.println(reducedNums.get(N));
    }
  }

  public static int calcNumDigits(int i) {
    int numdigit = 0;
    i /= 10;
    while (i > 0) {
      i /= 10;
      numdigit++;
    }
    return numdigit;
  }
}
