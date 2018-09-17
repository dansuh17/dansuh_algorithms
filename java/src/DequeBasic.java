import java.io.*;
import java.util.*;

/**
 * 백준 문제 10866번 '덱'
 * https://www.acmicpc.net/problem/10866
 */
public class DequeBasic {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    Deque<Integer> deque = new LinkedList<>();

    for (int n = 0; n < N; n++) {
      String[] commandStr = bf.readLine().split(" ");
      String baseCmd = commandStr[0];

      int elem;
      int result;
      switch (baseCmd) {
        case "push_back":
          elem = Integer.parseInt(commandStr[1]);
          deque.addLast(elem);
          break;
        case "push_front":
          elem = Integer.parseInt(commandStr[1]);
          deque.addFirst(elem);
          break;
        case "front":
          if (deque.isEmpty()) {
            System.out.println(-1);
          } else {
            result = deque.peekFirst();
            System.out.println(result);
          }
          break;
        case "back":
          if (deque.isEmpty()) {
            System.out.println(-1);
          } else {
            result = deque.peekLast();
            System.out.println(result);
          }
          break;
        case "size":
          System.out.println(deque.size());
          break;
        case "empty":
          int isempty = deque.isEmpty() ? 1 : 0;
          System.out.println(isempty);
          break;
        case "pop_back":
          if (deque.isEmpty()) {
            System.out.println(-1);
          } else {
            result = deque.removeLast();
            System.out.println(result);
          }
          break;
        case "pop_front":
          if (deque.isEmpty()) {
            System.out.println(-1);
          } else {
            result = deque.removeFirst();
            System.out.println(result);
          }
          break;
        default:
          break;
      }
    }
  }
}
