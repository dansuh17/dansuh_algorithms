import java.io.*;
import java.util.*;

/**
 * 백준 문제 2965번 '캥거루 세마리'
 * https://www.acmicpc.net/problem/2965
 */
class ThreeKangaroos {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] stringOpts = bf.readLine().trim().split(" ");
    int p1 = Integer.parseInt(stringOpts[0]);
    int p2 = Integer.parseInt(stringOpts[1]);
    int p3 = Integer.parseInt(stringOpts[2]);

    int size1 = p2 - p1;
    int size2 = p3 - p2;
    int largerSize = size1 > size2 ? size1 - 1: size2 - 1;

    bw.write(largerSize + "\n");
    bw.close();
  }
}
