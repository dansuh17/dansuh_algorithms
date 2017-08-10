import java.io.*;
import java.util.*;

/**
 * 백준 문제 9461번 '파도반 수열'
 * https://www.acmicpc.net/problem/9461
 *
 * An equilateral triangle of side length k is added to the longest side of a spiral,
 * where k is the length of the longest side of spiral.
 */
public class PadovanSequence {
  public static long padovan(int N) {
    // The sequence 1 1 1 2 2 are irregular and should be provided.
    // After this, the spiral forms a pentagon having four 120-deg vertices and one 60-deg vertex.
    // Then a formula is formed: padovan(N) = padovan(N - 1) + padovan(N - 5)

    // The equation padovan(N) = padovan(N - 2) + padovan(N - 3) also satisfies.
    long[] padovanSeq = new long[100];
    padovanSeq[0] = 1;
    padovanSeq[1] = 1;
    padovanSeq[2] = 1;
    padovanSeq[3] = 2;
    padovanSeq[4] = 2;

    for (int n = 5; n < N; n++) {
      padovanSeq[n] = padovanSeq[n - 1] + padovanSeq[n - 5];
    }

    return padovanSeq[N - 1];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(bf.readLine());
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(bf.readLine());
      System.out.println(padovan(N));
    }
  }
}
