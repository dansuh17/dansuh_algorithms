import java.io.*;
import java.util.*;

/**
 * 백준 문제 10989번 '수 정렬하기 3'
 * https://www.acmicpc.net/problem/10989
 */
public class CountSort {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(bf.readLine());
    int[] elems = new int[10001];

    for (int n = 0; n < N; n++) {
      int e = Integer.parseInt(bf.readLine());
      elems[e]++;
    }

    for (int i = 0; i < elems.length; i++) {
      int count = elems[i];

      if (count > 0) {
        while (count-- > 0) {
          bw.write(i + "\n");
        }
      }
    }
    bw.close();
  }
}
