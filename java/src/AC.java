import java.io.*;
import java.util.*;

/**
 * 백준 문제 5430번 'AC'
 * https://www.acmicpc.net/problem/5430
 */
public class AC {
  /**
   * Operate AC language command onto an array (represented as deque)
   * @param deque deque containing integers
   * @param command AC language command string
   * @return string representation of the command result, 'error' if error
   */
  static String operateCommand(Deque<Integer> deque, String command) {
    boolean reverse = false;

    for (int i = 0; i < command.length(); i++) {
      char c = command.charAt(i);
      if (c == 'R') {
        reverse = !reverse;
      } else if (c == 'D') {
        if (deque.isEmpty()) {
          return "error";  // invalid operation
        } else {
          if (reverse) {
            deque.removeLast();
          } else {
            deque.removeFirst();
          }
        }
      }
    }

    return makeToString(deque, reverse);
  }

  /**
   * Convert a deque content to string
   * @param deque deque of integer
   * @param reverse indicating whether the representation should be reversed
   * @return a string representation of deque contents
   */
  static String makeToString(Deque<Integer> deque, boolean reverse) {
    StringBuilder sb = new StringBuilder();
    // open bracket
    sb.append('[');

    while (!deque.isEmpty()) {
      if (reverse) {
        sb.append(deque.removeLast());
      } else {
        sb.append(deque.removeFirst());
      }

      if (!deque.isEmpty()) {
        sb.append(',');
      }
    }

    // close bracket
    sb.append(']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());

    for (int t = 0; t < T; t++) {
      String command = bf.readLine().trim();
      int N = Integer.parseInt(bf.readLine());
      String arrayStr = bf.readLine().trim()
          .replace("[", "")
          .replace("]", "");

      String[] arrayStrs = arrayStr.split(",");
      Deque<Integer> deque = new LinkedList<>();
      for (int n = 0; n < N; n++) {
        deque.addLast(Integer.parseInt(arrayStrs[n]));
      }

      System.out.println(operateCommand(deque, command));
    }
  }
}
