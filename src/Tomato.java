import java.util.*;
import java.io.*;

/**
 * 백준 문제 7576번 '토마토'
 * https://www.acmicpc.net/problem/7576
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
public class Tomato {
  private int numTomatos;
  private int row;
  private int col;
  private int numRipe;
  private List<LinkedList<Integer>> tomatoBox = new ArrayList<LinkedList<Integer>>();
  private int ripe[];

  Tomato(int numTomato, int rowNum, int colNum) {
    row = rowNum;
    col = colNum;
    numTomatos = numTomato;
    ripe = new int[numTomatos];
    for (int t = 0; t < numTomatos; t++) {
      tomatoBox.add(new LinkedList<Integer>());
    }
  }

  void addAdjacent(int from, int to) {
    tomatoBox.get(from).add(to);
  }

  void setRipe(int tomato, int ripe) {
    this.ripe[tomato] = ripe;
    if (ripe == 1) {
      numRipe++;
    }
  }

  static int numTomato(int rowIdx, int rowSize, int col) {
    // the number for the tomato is : row_idx * rowsize + col_idx
    return rowIdx * rowSize + col;
  }

  void printBox(int day) {
    System.out.println("Printing box for day :" + day);
    int tomatoId = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        System.out.print(ripe[tomatoId] + " ");
        tomatoId++;
      }
      System.out.print('\n');
    }
    System.out.print('\n');
  }

  // returns ripe status.
  // 1 for ripe, 0 for raw, -1 for not existing
  int getRipe(int tomato) {
    return ripe[tomato];
  }

  /**
   * 익혀라ㅏㅏㅏ
   */
  int letRipe() {
    // fill the queue with initially ripe tomatos
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < numTomatos; i++) {
      if (getRipe(i) == 1) queue.add(i);
    }

    int date = 0;  // first day
    while (!queue.isEmpty()) {
      printBox(date);
      // the tomato that riped today
      Queue<Integer> thisDayRiped = new LinkedList<Integer>();
      while (!queue.isEmpty()) {
        int alreadyRiped = queue.poll();
        thisDayRiped.add(alreadyRiped);
      }

      // then add tomato that should ripe tomorrow
      while (!thisDayRiped.isEmpty()) {
        int alreadyRiped = thisDayRiped.poll();
        System.out.println("Influence by : " + alreadyRiped);

        // all tomatoes adjacent - top, bottom, left, right
        Iterator<Integer> iterator = tomatoBox.get(alreadyRiped).iterator();
        while (iterator.hasNext()) {
          int nexttoRipe = iterator.next();

          if (ripe[nexttoRipe] == 0) {  // yet raw
            System.out.println("Next ripe : " + nexttoRipe);
            queue.add(nexttoRipe);
            ripe[nexttoRipe] = 1;  // set to ripe
            numRipe++;
          }
        }
      }
      date++;
    }

    if (numRipe == numTomatos) {
      // here we subtract 1 because the last ripe tomatos did not influence any other to ripe.
      date -= 1;
    } else {
      date = -1;
    }
    return date;
  }

  public void addTomatoIfOk(int from, int r, int c) {
    // the tomato should be within the box AND it should exist
    int tomatoNum = numTomato(r, this.col, c);
    if (tomatoNum >= 0 && tomatoNum < this.col * this.row && getRipe(tomatoNum) != -1
      && r >= 0 && r < this.row && c >= 0 && c < this.col) {
      addAdjacent(from, tomatoNum);
    }
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] inputStr = bf.readLine().split(" ");
    int col = Integer.parseInt(inputStr[0]);
    int row = Integer.parseInt(inputStr[1]);
    Tomato tomato = new Tomato(col * row, row, col);
    System.out.println("Box size : " + col + " x " + row);

    // read row by row and add tomatoes into the box
    for (int r = 0; r < row; r++) {
      String[] thisTomatoRow = bf.readLine().split(" ");

      for (int c = 0; c < col; c++) {
        int thisTomato = Tomato.numTomato(r, col, c);
        // 1 == ripe, 0 == raw, -1 == no tomato
        int ripe = Integer.parseInt(thisTomatoRow[c]);
        tomato.setRipe(thisTomato, ripe);  // put a tomato in the box
      }
    }

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        // 앞 뒤 좌 우 토마토 추가
        int from = Tomato.numTomato(r, col, c);
        tomato.addTomatoIfOk(from, r - 1, c);
        tomato.addTomatoIfOk(from, r + 1, c);
        tomato.addTomatoIfOk(from, r, c + 1);
        tomato.addTomatoIfOk(from, r, c - 1);
      }
    }

    System.out.println(tomato.letRipe());  // starting point!
  }
}
