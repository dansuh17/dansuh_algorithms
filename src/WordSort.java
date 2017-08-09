import java.io.*;
import java.util.*;

/**
 * 백준 문제 1181번 '단어 정렬'
 * https://www.acmicpc.net/problem/1181
 */
public class WordSort {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(bf.readLine());
    List<ArrayList<String>> wordCounts = new ArrayList<>();

    for (int i = 0; i < 51; i++) {
      wordCounts.add(new ArrayList<>());
    }

    for (int n = 0; n < N; n++) {
      String word = bf.readLine().trim();
      int length = word.length();
      ArrayList<String> wordsWithThisLength = wordCounts.get(length);

      // do not allow duplicates
      if (wordsWithThisLength.indexOf(word) == -1) {
        wordCounts.get(length).add(word);
      }
    }

    for (int i = 0; i < 51; i++) {
      ArrayList<String> sameLengthWords = wordCounts.get(i);
      if (sameLengthWords.size() > 0) {
        Collections.sort(sameLengthWords);  // sort the strings

        for (String sameLengthWord : sameLengthWords) {
          bw.write(sameLengthWord + "\n");
        }
      }
    }
    bw.close();
  }
}
