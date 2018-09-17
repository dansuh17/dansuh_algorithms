import java.io.*;
import java.util.*;

/**
 * 백준 문제 7568번 '덩치'
 * https://www.acmicpc.net/problem/7568
 */
public class DungChi {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    List<Dung> people = new ArrayList<>();

    for (int n = 0; n < N; n++) {
      String[] weightheight = bf.readLine().trim().split(" ");
      int weight = Integer.parseInt(weightheight[0]);
      int height = Integer.parseInt(weightheight[1]);
      people.add(new Dung(weight, height));
    }

    int[][] compareChart = new int[N][N];

    for (int i = 0; i < N; i++) {
      Dung pivot = people.get(i);

      for (int j = i; j < N; j++) {
        Dung against = people.get(j);
        int compareResult = Dung.compare(pivot, against);

        compareChart[i][j] = compareResult;
        compareChart[j][i] = -compareResult;
      }
    }

    // iterate through and find the rank
    for (int i = 0; i < N; i++) {
      int rank = 1;
      for (int j = 0; j < N; j++) {
        if (compareChart[i][j] < 0) rank++;
      }

      System.out.println(rank);
    }
  }
}

class Dung {
  private int weight;
  private int height;

  Dung(int weight, int height) {
    this.weight = weight;
    this.height = height;
  }

  static int compare(Dung d1, Dung d2) {
    if (d1.weight > d2.weight && d1.height > d2.height) {
      return 1;  // d1 larger dungchi than d2
    } else if (d1.weight < d2.weight && d1.height < d2.height) {
      return -1;  // d2 larger dungchi than d1
    } else {
      return 0;  // cannot determine
    }
  }
}
