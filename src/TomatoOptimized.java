import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 백준 문제 7576번 '토마토'
 * https://www.acmicpc.net/problem/7576
 *
 * 2D array를 써서 시간 최적화
 *
 * Example input:
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 *
 * Example output:
 * 8
 *
 */
public class TomatoOptimized {
  public static void printBox(List<ArrayList<TomatoClass>> tomatoBox, int day) {
    int col = tomatoBox.get(0).size();

    System.out.println("For Day : " + day);
    for (ArrayList<TomatoClass> aTomatoBox : tomatoBox) {
      for (int c = 0; c < col; c++) {
        System.out.print(aTomatoBox.get(c).days + " ");
      }
      System.out.println();
    }
  }

  public static boolean tomatoExists(int row, int col, int maxRow, int maxCol) {
    return row >= 0 && col >= 0 && row < maxRow && col < maxCol;
  }

  public static int startRipe(List<ArrayList<TomatoClass>> tomatoBox, int ripeCount, Queue<TomatoClass> q, int totalCount) {
    int maxDay = 0;
    int maxRow = tomatoBox.size();
    int maxCol = tomatoBox.get(0).size();

    while (!q.isEmpty() && totalCount != ripeCount) {
      TomatoClass tomato = q.poll();
      int r = tomato.row;
      int c = tomato.col;
      int ripeDay = tomato.days;
      int nextDay = ripeDay + 1;

      // top
      if (tomatoExists(r - 1, c, maxRow, maxCol)) {
        TomatoClass nextCandidateTomato = tomatoBox.get(r - 1).get(c);
        if (nextCandidateTomato.ripe == 0) {
          nextCandidateTomato.ripe = 1;
          ripeCount++;
          nextCandidateTomato.days = nextDay;
          q.add(nextCandidateTomato);
        }
      }

      // bottom
      if (tomatoExists(r + 1, c, maxRow, maxCol)) {
        TomatoClass nextCandidateTomato = tomatoBox.get(r + 1).get(c);
        if (nextCandidateTomato.ripe == 0) {
          nextCandidateTomato.ripe = 1;
          ripeCount++;
          nextCandidateTomato.days = nextDay;
          q.add(nextCandidateTomato);
        }
      }

      // right
      if (tomatoExists(r, c + 1, maxRow, maxCol)) {
        TomatoClass nextCandidateTomato = tomatoBox.get(r).get(c + 1);
        if (nextCandidateTomato.ripe == 0) {
          nextCandidateTomato.ripe = 1;
          ripeCount++;
          nextCandidateTomato.days = nextDay;
          q.add(nextCandidateTomato);
        }
      }

      // left
      if (tomatoExists(r, c - 1, maxRow, maxCol)) {
        TomatoClass nextCandidateTomato = tomatoBox.get(r).get(c - 1);
        if (nextCandidateTomato.ripe == 0) {
          nextCandidateTomato.ripe = 1;
          ripeCount++;
          nextCandidateTomato.days = nextDay;
          q.add(nextCandidateTomato);
        }
      }

      if (maxDay < nextDay) {
        maxDay = nextDay;
        printBox(tomatoBox, maxDay);
      }
    }

    return ripeCount == totalCount ? maxDay : -1;
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] inputStr = bf.readLine().split(" ");
    int col = Integer.parseInt(inputStr[0]);
    int row = Integer.parseInt(inputStr[1]);

    // create tomato box: array list of array list
    List<ArrayList<TomatoClass>> tomatoBox = new ArrayList<ArrayList<TomatoClass>>();
    Queue<TomatoClass> queue = new LinkedList<TomatoClass>();
    int ripeCount = 0;
    int totalCount = 0;

    for (int r = 0; r < row; r++) {
      String[] thisRow = bf.readLine().split(" ");
      tomatoBox.add(new ArrayList<TomatoClass>());  // new row

      for (int c = 0; c < col; c++) {
        int ripe = Integer.parseInt(thisRow[c]);
        int days = -1;
        TomatoClass thisTomato;

        if (ripe != -1) {
          totalCount++;
        }

        if (ripe == 1) {
          ripeCount++;
          days = 0;
          thisTomato = new TomatoClass(ripe, days, r, c);
          tomatoBox.get(r).add(thisTomato);
          queue.add(thisTomato);
        } else {
          thisTomato = new TomatoClass(ripe, days, r, c);
          tomatoBox.get(r).add(thisTomato);
        }
      }
    }

    int d = startRipe(tomatoBox, ripeCount, queue, totalCount);
    System.out.println(d);
  }
}

class TomatoClass {
  int ripe;
  int days;
  int row;
  int col;

  public TomatoClass(int ripe, int days, int row, int col) {
    this.ripe = ripe;
    this.days = days;
    this.row = row;
    this.col = col;
  }
}
