import java.io.*;
import java.util.*;

/**
 * 백준 문제 10845번 '큐'
 * https://www.acmicpc.net/problem/10845
 */
public class QueueBasic {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    LinkedList<Integer> q = new LinkedList<>();

    for (int n = 0; n < N; n++) {
      String[] cmds = bf.readLine().trim().split(" ");
      switch (cmds[0]) {
        case "push":
          int k = Integer.parseInt(cmds[1]);
          q.add(k);
          break;
        case "pop":
          if (q.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(q.pollFirst());
          }
          break;
        case "front":
          if (q.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(q.peekFirst());
          }
          break;
        case "back":
          if (q.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(q.peekLast());
          }
          break;
        case "size":
          System.out.println(q.size());
          break;
        case "empty":
          int l = q.isEmpty() ? 1 : 0;
          System.out.println(l);
          break;
        default:
          break;
      }
    }
  }
}
