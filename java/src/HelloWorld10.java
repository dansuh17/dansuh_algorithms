import java.io.*;
import java.util.*;

/**
 * 백준 문제 2577번 '숫자의 개수'
 * https://www.acmicpc.net/problem/2577
 */
public class HelloWorld10 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int n1 = Integer.parseInt(bf.readLine().trim());
    int n2 = Integer.parseInt(bf.readLine().trim());
    int n3 = Integer.parseInt(bf.readLine().trim());

    long total = n1 * n2 * n3;

    String totalS = Long.toString(total);  // Long -> String

    List<Integer> counts = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      counts.add(0);
    }

    for (int i = 0; i < totalS.length(); i++) {
      char c = totalS.charAt(i);
      int thisDigit = c - '0';  // 꼼수

      int originalCount = counts.get(thisDigit);
      counts.set(thisDigit, originalCount + 1);
    }

    for (int val : counts) {
      System.out.println(val);
    }

    bw.close();
  }
}