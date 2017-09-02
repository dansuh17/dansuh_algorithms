import java.io.*;

/**
 * 백준 문제 9251번 'Longest Common Subsequence'
 * https://www.acmicpc.net/problem/9251
 */
public class LCS {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s1 = bf.readLine().trim();
    String s2 = bf.readLine().trim();

    bw.write(lcsLength(s1, s2) + "\n");
    bw.close();
  }

  static int lcsLength(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();
    int[][] lcs = new int[len1][len2];

    for (int i = 0; i < len1; i++) {
      char c1 = s1.charAt(i);

      for (int j = 0; j < len2; j++) {
        char c2 = s2.charAt(j);

        if (c1 == c2) {
          // if c1 == c2, lcs[i][j] = lcs[i - 1][j - 1] + 1
          if (i > 0 && j > 0) {
            lcs[i][j] = lcs[i - 1][j - 1] + 1;
          } else {
            lcs[i][j] = 1;
          }
        } else {
          // if c1 != c2, lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
          if (i == 0 && j == 0) {
            lcs[i][j] = 0;
          } else if (i == 0) {
            lcs[i][j] = lcs[i][j - 1];
          } else if (j == 0) {
            lcs[i][j] = lcs[i - 1][j];
          } else {
            int lcsPrevRow = lcs[i - 1][j];
            int lcsPrevCol = lcs[i][j - 1];
            lcs[i][j] = lcsPrevCol > lcsPrevRow ? lcsPrevCol : lcsPrevRow;
          }
        }
      }
    }

    return lcs[len1 - 1][len2 - 1];
  }
}