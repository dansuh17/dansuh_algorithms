import java.io.*;
import java.util.*;

/**
 * 백준 문제 9252번 'LCS 2'
 * https://www.acmicpc.net/problem/9252
 */
public class LCS2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s1 = bf.readLine().trim();
    String s2 = bf.readLine().trim();

    int n1 = s1.length();
    int n2 = s2.length();

    int[][] lcs = new int[n1][n2];
    String[][] lcsStr = new String[n1][n2];

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        lcsStr[i][j] = "";
      }
    }

    for (int i = 0; i < n1; i++) {
      char c1 = s1.charAt(i);
      for (int j = 0; j < n2; j++) {
        char c2 = s2.charAt(j);

        if (c1 == c2) {
          if (i > 0 && j > 0) {
            lcs[i][j] = lcs[i - 1][j - 1] + 1;
            lcsStr[i][j] = lcsStr[i - 1][j - 1] + String.valueOf(c1);
          } else {
            lcs[i][j] = 1;
            lcsStr[i][j] = String.valueOf(c1);
          }
        } else {
          int xOffset = 0;
          String xOffsetChar = "";
          if (i > 0) {
            xOffset = lcs[i - 1][j];
            xOffsetChar = lcsStr[i - 1][j];
          }

          int yOffset = 0;
          String yOffsetChar = "";
          if (j > 0) {
            yOffset = lcs[i][j - 1];
            yOffsetChar = lcsStr[i][j - 1];
          }

          if (xOffset > yOffset) {
            lcs[i][j] = xOffset;
            lcsStr[i][j] = xOffsetChar;
          } else {
            lcs[i][j] = yOffset;
            lcsStr[i][j] = yOffsetChar;
          }
        }
      }
    }

    bw.write(lcs[n1 - 1][n2 - 1] + "\n");
    bw.write(lcsStr[n1 - 1][n2 - 1] + "\n");
    bw.close();
  }
}