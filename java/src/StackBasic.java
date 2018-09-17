import java.io.*;
import java.util.*;

/**
 * 백준 문제 10828번 '스택'
 * https://www.acmicpc.net/problem/10828
 */
public class StackBasic {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < N; i++) {
      String[] commands = bf.readLine().split(" ");
      switch (commands[0]) {
        case "push":
          int elem = Integer.parseInt(commands[1]);
          stack.push(elem);
          break;
        case "top":
          if (stack.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(stack.peek());
          }
          break;
        case "size":
          System.out.println(stack.size());
          break;
        case "pop":
          if (stack.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(stack.pop());
          }
          break;
        case "empty":
          int isempt = stack.isEmpty() ? 1 : 0;
          System.out.println(isempt);
          break;
        default:
          break;
      }
    }
  }
}
