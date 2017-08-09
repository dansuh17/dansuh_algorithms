import java.io.*;
import java.util.*;

/**
 * 백준 문제 1427번 '소트 인사이드'
 * https://www.acmicpc.net/problem/1427
 */
public class SortInside {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String number = bf.readLine().trim();
    int[] counts = new int[10];

    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      counts[c - '0']++;
    }

    for (int i = 9; i >= 0; i--) {
      int count = counts[i];
      if (count > 0) {
        while (count-- > 0) {
          bw.write(i + "");
        }
      }
    }
    bw.write("\n");
    bw.close();
  }
}
